$(document).ready(function(){
	
	$('#write_img_btn').click(function(){		
		$("#contents").load("FormJsp/boardWriteForm.jsp");
	});
});//end 익명함수----------------------------------------------------------------->

function reply(replyBtn){//자유게시판 댓글쓰기 버튼 클릭시
	var rStr = replyBtn.name;//name에 넣어둔 값들을 받아온다.
	var arr = rStr.split(",");//,를 제외하고 배열화 한다.
	//댓글쓰기에 필요한 정보를 갖고 writeForm.jsp 페이지 로드
	var query = "FormJsp/boardWriteForm.jsp?num="+arr[0]+"&ref="+arr[1];
	query += "&re_step="+arr[2]+"&re_level="+arr[3]+"&pageNum="+arr[4];
	$("#contents").load(query);
}