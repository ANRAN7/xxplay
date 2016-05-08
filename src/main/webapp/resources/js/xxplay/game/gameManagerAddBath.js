$(function(){
	$("#gameAddBathForm").fileupload({
        url: '../gameManager/uploadGameInfoAndRead',
        acceptFileTypes:  /(\.|\/)(xlsx)$/
    });
});