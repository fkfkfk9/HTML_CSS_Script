var num = $("#num").val();
var replyPage = 1;
var status = true;
var first = true;

//만약 처음 들어온거라면 댓글출력 함수를 실행한다.
if(first){
	first = false;
	getReplyList("/replies/"+num+"/"+replyPage );
}
//댓글을 출력해준다.
function getReplyList(pageInfo) {
	$.getJSON(pageInfo, function(data) {
		var str = "";
		var i = 0;
		$(data.replyVO).each(function() {
			str += "<li data-rno='"+this.rno+"' class='replyLi' >"
				+ "<b><span class='writer_id'>" + this.replyer + "</span></b>"   
				+ "<button class='updateBtn'>수정</button>" 
				+ "<button onclick='deleteBtn(" + this.rno + ")'>삭제</button><br>"
				+ "<span class='writer_sbuject'>" + this.replytext + "</span>" 
				+ "<span class='write_date'>"+ this.updatedate + "</span></li>";
			i++;
		});//END OF data.replyVO		
		
		$("#replyList").html(str);
		str = "";
		if (data.pageBtn.prev) {
			str += "<li><a href='" + (data.pageBtn.startPage - 1)
					+ "'> << </a></li>";
		}
		for (var i = data.pageBtn.startPage, len = data.pageBtn.endPage; i <= len; i++) {
			var strClass = data.pageBtn.paging.pageNum == i ? 'class=active' : '';
			str += "<li "+strClass+"><a href='"+i+"'>" + i + "</a></li>";
		}
		if (data.pageBtn.next) {
			str += "<li><a href='" + (data.pageBtn.endPage + 1)
					+ "'> >> </a></li>";
		}
		$(".pagination").html(str);
		$('.active').css('background', '#bfbfff');
	});//END OF getJSON
}//END OF getReplyList

$(".pagination").on("click", "li a", function(event){//리플의 페이징 버튼	
	event.preventDefault();	
	replyPage = $(this).attr("href");	
	$('.replyLi').remove();
	getReplyList("/replies/"+num+"/"+replyPage);	
});



//리플 추가 
$("#replyAddBtn").on("click",function(){
     checkIt();
	 if(status){
    	 var replyerObj = $("#replyer");
	 	 var replytextObj = $("#replytext");
    	 var replyer = replyerObj.val();        	 
    	 var replytext = replytextObj.val();
    	 
    	  $.ajax({
    			type:'post',
    			url:'/replies/',
    			headers: { 
    			      "Content-Type": "application/json",
    			      "X-HTTP-Method-Override": "POST" },
    			dataType:'text',
    			data: JSON.stringify({num:num, replyer:replyer, replytext:replytext}),
    			success:function(result){
    				console.log("result: " + result);
    				if(result == 'SUCCESS'){
    					alert("등록 되었습니다.");
    					replyPage = 1;
    					$('.replyLi').remove();
    					getReplyList("/replies/"+num+"/"+replyPage );
    					$("#replyer").val("");
    					$("#replytext").val("");
    				}//END OF 리턴함수---------------------------------------------->
    		}});//END OF AJAX ---------------------------------------------------------->
	 }//END OF IF----------------------------------------------------------------------------->
});//END OF 리플 추가 버튼----------------------------------------------------------------------------->    


function deleteBtn(rno){//삭제 함수 onclick로 불러온다.
	 $.ajax({
			type:'delete',
			url:'/replies/'+rno,
			headers: { 
			      "Content-Type": "application/json",
			      "X-HTTP-Method-Override": "DELETE" },
			dataType:'text', 
			success:function(result){
				console.log("result: " + result);
				if(result == 'SUCCESS'){
					alert("삭제 되었습니다.");
					$('.replyLi').remove();
					getReplyList("/replies/"+num+"/"+replyPage);
				}
		}
	 });//END OF AJAX------------------------------------------>
}//END OF 리플 삭제 버튼--------------------------------------------------------------->

$("#replyList").on("click", ".replyLi button.updateBtn", function() {
	var reply = $(this).parent();	
	var rno = reply.attr("data-rno");
	var now_id = reply.attr("id");
	var replytext = reply.find(".writer_sbuject").text();
	$('.updatediv').remove();
	reply.append("<div data-rno='"+rno+"' class='updatediv'><textarea rows='3' id='updatetext' cols='55'>"
			+replytext+"</textarea><br>" 
			+ "<button class='modifyBtn'>Modify</button><button class='closeBtn'>Close</button><div>");		
});//END OF 수정 ------------------------------------------------------------>

$("#replyList").on("click", ".replyLi .updatediv button.closeBtn", function() {//수정 창을 닫는다.
	$('.updatediv').remove();
});//END OF CLOSE------------------------------------------------------------>

$("#replyList").on("click", ".replyLi .updatediv button.modifyBtn", function() {
	 var reply = $(this).parent();	
	 var rno = reply.attr("data-rno");
	 var replytext = reply.find('#updatetext').text();
	 
	  $.ajax({
			type:'put',
			url:'/replies/'+rno,
			headers: { 
			      "Content-Type": "application/json",
			      "X-HTTP-Method-Override": "PUT" },
			dataType:'text',
			data: JSON.stringify({rno:rno, replytext:replytext}),
			success:function(result){
				console.log("result: " + result);
				if(result == 'SUCCESS'){
					alert("수정 되었습니다.");
					$('.replyLi').remove();
					getReplyList("/replies/"+num+"/"+replyPage );					
			}//END OF 리턴함수---------------------------------------------->
	}});//END OF AJAX ---------------------------------------------------------->
});//END OF CLOSE------------------------------------------------------------>

function checkIt(){//리플 입력 폼 체크
	status = true;
	if(!$.trim($("#replyer").val())){
		alert("작성자 아이디를 입력하시오.");		
		$("#replyer").focus();
		status = false;//스테이터스의 값을 바꿔줌으로써 ajax함수로의 진입을 막는다.
		return false;//리턴값을 false를 주면 함수가 종료되면서 밑의 코드를 진행 안한다.
	}	
	if(!$.trim($("#replytext").val())){
		alert("내용을 입력하세요.");		
		$("#replytext").focus();
		status = false;
		return false;
	}
}