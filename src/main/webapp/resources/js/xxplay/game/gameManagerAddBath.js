$(function(){
	$("#gameAddBathForm").fileupload({
        url: '../gameManager/uploadGameInfoAndRead',
        acceptFileTypes:  /(\.|\/)(xlsx)$/,
        dataType: 'json',
        done:function(e,data){
        }
    });
});