package com.xxplay.common.utils.xxplay;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xmlpull.v1.XmlPullParser;

import sun.security.pkcs.*;

import android.content.res.AXmlResourceParser;
import android.util.TypedValue;

import com.JUtils.file.FileUtils;
import com.xxplay.common.core.AppConstants;
import com.xxplay.common.core.AppContextUtils;
import com.xxplay.common.exception.ServiceException;

/**
 * 解析APK包，获取APK文件中的包名、版本号、ICON图标<br>
 * APK包本身就相当于zip文件。主要步骤是先通过zip解压apk，然后通过解析AndroidManifest.xml的方式获取相应的信息，其中对应关系为：<br>
 * versionCode：版本号<br>
 * versionName：版本名<br>
 * package：包名<br>
 * IOCN图标：主要是获取res/drawable-ldpi/icon.png路径下的icon.png图片
 *
 * @Author:chenssy
 * @date:2016年4月30日 下午1:39:18
 * 
 */
public class ApkReadUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApkReadUtils.class);
	
	private static final float RADIX_MULTS[] = { 0.00390625F, 3.051758E-005F, 1.192093E-007F, 4.656613E-010F };
	private static final String DIMENSION_UNITS[] = { "px", "dip", "sp", "pt", "in", "mm", "", "" };
	private static final String FRACTION_UNITS[] = { "%", "%p", "", "", "", "", "", "" };
	
	/**
	 * 解析apk包<br>
	 *
	 * @param apkPath	apk的路径
	 * @param iconPath	icon的存放路径
	 * @return
	 *
	 * @author:chenssy
	 * @throws Exception 
	 * @date : 2016年4月30日 下午9:06:44
	 */
	public static Map<String, Object> readApk(String apkPath,String iconPath) throws Exception{
		LOGGER.info("开始解析APK文件：：：apkPath:" + apkPath);
		long beginTime = System.currentTimeMillis();
		ZipFile zipFile = null;			//zip
		//icon图片
		String fileName = new File(apkPath).getName();
		String iconFileName = fileName.substring(0,fileName.lastIndexOf(".")) + "_icon.png";
		Map<String, Object> packInfo = new HashMap<String, Object>();
		try {
			zipFile = new ZipFile(new File(apkPath));
			Enumeration<?> enumeration = zipFile.entries();
			ZipEntry zipEntry = null;
			while (enumeration.hasMoreElements()) {
				zipEntry = (ZipEntry) enumeration.nextElement();
				if (zipEntry.isDirectory()) {

				} else {
					if ("AndroidManifest.xml".equals(zipEntry.getName())) {
						try {
							AXmlResourceParser parser = new AXmlResourceParser();
							parser.open(zipFile.getInputStream(zipEntry));
							while (true) {
								int type = parser.next();
								if (type == XmlPullParser.END_DOCUMENT) {
									break;
								}
								switch (type) {
								case XmlPullParser.START_TAG: {
									for (int i = 0; i != parser.getAttributeCount(); ++i) {
										if ("versionName".equals(parser.getAttributeName(i))) {		//版本名称
											packInfo.put("verName", getAttributeValue(parser, i));
										} else if("versionCode".equals(parser.getAttributeName(i))){	//版本号
											packInfo.put("verCode", Integer.valueOf(getAttributeValue(parser, i)));
										}else if ("package".equals(parser.getAttributeName(i))) {	//包名
											packInfo.put("packageName", getAttributeValue(parser, i));
										}
									}
								}
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					//icon图标
					if ("res/drawable-hdpi/icon.png".equals(zipEntry.getName())) {
						FileUtils.isExist(iconPath,true);		//判断该路径是否存在
						FileOutputStream  fos = new FileOutputStream(iconPath + "/" + iconFileName);
						InputStream inputStream = zipFile.getInputStream(zipEntry);
						byte b[] = new byte[1024];
						int length;
						try {
							while ((length = inputStream.read(b)) > 0){
								fos.write(b, 0, length);
							}
						} catch (Exception e) {
							e.printStackTrace();
						} finally{
							fos.close();
							inputStream.close();
						}
					}
					//签名信息
					if ("META-INF/CERT.RSA".equals(zipEntry.getName())){
						X509Certificate publicKey = readSignatureBlock(new FileInputStream("./CERT.RSA")); 
						packInfo.put("signCode", publicKey.getPublicKey().toString());
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error("解析apk文件失败，apkPath:" + apkPath + "....." + e.getMessage());
			e.printStackTrace();
			throw new ServiceException(null, "解析apk文件失败");
		} finally{
			zipFile.close();
		}
		//MD5信息
		packInfo.put("packMd5", FileUtils.getFileMD5(new File(apkPath)).toUpperCase());
		//文件大小
		packInfo.put("packSize", FileUtils.getFileSize(new File(apkPath)));
		//icon地址--将图片路径进行处理
		packInfo.put("iconTempUrl",AppContextUtils.getPropertiesValue(AppConstants.GAME_APP_PACK_ICON_TEMP_PATH) + "/" + iconFileName );
		
		//apk下载地址

		packInfo.put("packUrl", AppContextUtils.getPropertiesValue(AppConstants.GAME_APP_PACK_REAL_PATH) + "/" + fileName);
		//icon保存路径
		packInfo.put("iconPicurl", AppContextUtils.getPropertiesValue(AppConstants.GAME_APP_PACK_ICON_REAL_PATH) + "/" + iconFileName);
		
		LOGGER.info("解析APK完成。所花时间为：" + (System.currentTimeMillis() - beginTime) + "毫秒。apk名称：" + new File(apkPath).getName() + ",apk大小为：" + packInfo.get("packSize"));
		return packInfo;
	}
	
	/**
	 * 获取属性的值
	 *
	 * @param parser
	 * @param index
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月30日 下午9:44:36
	 */
	private static String getAttributeValue(AXmlResourceParser parser, int index) {
		int type = parser.getAttributeValueType(index);
		int data = parser.getAttributeValueData(index);
		if (type == TypedValue.TYPE_STRING) {
			return parser.getAttributeValue(index);
		}
		if (type == TypedValue.TYPE_ATTRIBUTE) {
			return String.format("?%s%08X", getPackage(data), data);
		}
		if (type == TypedValue.TYPE_REFERENCE) {
			return String.format("@%s%08X", getPackage(data), data);
		}
		if (type == TypedValue.TYPE_FLOAT) {
			return String.valueOf(Float.intBitsToFloat(data));
		}
		if (type == TypedValue.TYPE_INT_HEX) {
			return String.format("0x%08X", data);
		}
		if (type == TypedValue.TYPE_INT_BOOLEAN) {
			return data != 0 ? "true" : "false";
		}
		if (type == TypedValue.TYPE_DIMENSION) {
			return Float.toString(complexToFloat(data)) + DIMENSION_UNITS[data & TypedValue.COMPLEX_UNIT_MASK];
		}
		if (type == TypedValue.TYPE_FRACTION) {
			return Float.toString(complexToFloat(data)) + FRACTION_UNITS[data & TypedValue.COMPLEX_UNIT_MASK];
		}
		if (type >= TypedValue.TYPE_FIRST_COLOR_INT && type <= TypedValue.TYPE_LAST_COLOR_INT) {
			return String.format("#%08X", data);
		}
		if (type >= TypedValue.TYPE_FIRST_INT && type <= TypedValue.TYPE_LAST_INT) {
			return String.valueOf(data);
		}
		return String.format("<0x%X, type 0x%02X>", data, type);
	}
	
	/**
	 * 获取包
	 *
	 * @param id
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月30日 下午9:46:00
	 */
	private static String getPackage(int id) {
		if (id >>> 24 == 1) {
			return "android:";
		}
		return "";
	}

	private static float complexToFloat(int complex) {
		return (float) (complex & 0xFFFFFF00) * RADIX_MULTS[(complex >> 4) & 3];
	}
	
	@SuppressWarnings("restriction")
	private static X509Certificate readSignatureBlock(InputStream in) throws IOException, GeneralSecurityException {  
         PKCS7 pkcs7 = new PKCS7(in);  
         return pkcs7.getCertificates()[0];  
     } 
	
//	public static void main(String[] args) throws Exception {
//		PackInfo info = ApkReadUtils.readApk("c:/baidushurufa.apk", "c:/11/1234.png");
//		System.out.println(info.getPackMd5());
//		System.out.println(info.getPackSize());
//		System.out.println(info.toString());
//	}
}
