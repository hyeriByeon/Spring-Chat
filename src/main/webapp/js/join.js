var result = 0;
var pattern = /^[A-Za-z0-9]{4,12}$/;
$(document).ready(function(){
	$("#chk_btn").click(function(){
		if($("#userId").val()){
			var userId = {
				userId : $("#userId").val()
			};// varQuery
			
			$.ajax({
				type : "get",
				url : "/JoinCheck",
				data : userId,// para 1/ -1
				
				success:function(data){
					if(data == 1){// 아이디가 있으면
						alert("이미 존재하는 아이디 입니다.");
						$("#userId").val("");
						$("#userId").focus();
					}else if(data == -1 && pattern.test($("#userId").val())){
						alert("사용할 수 있는 아이디");
						result = 1;
						$("#chkOkId").val($('#userId').val());

					}else{
						alert('사용할 수  없는 아이디.');
					}
				}// success
			});// ajax
			
		} else{
			alert("사용할 아이디를 입력하세요.");
			$("#userId").focus();
		}// else
	});// click
});

function toCheckPass() { 
	var userMail = document.getElementById("userMail").value + "@" + document.getElementById("userMail2").value;
	var pw = document.getElementById("userPw").value;
    var pwck = document.getElementById("userPw2").value;
    var id = document.getElementById("userId").value;
    alert(userMail);
    $("#userMail_check").val(userMail);
		if(id.length < 4 || pw.length < 4 || pwck.length < 4){
			alert('4-12 사이의 영문, 숫자만 사용할 수 있습니다.');
			return false;
		}
		
		if(!pattern.test(id)){
			alert('4-12 사이의 영문, 숫자만 사용할 수 있습니다.');
			return false;
		} else if (!pattern.test(pw)){
			alert('4-12 사이의 영문, 숫자만 사용할 수 있습니다.');
			return false;
		}
    	if (pw != pwck) {
            alert('비밀번호가 일치하지 않습니다. 다시 확인해주세요.');
            return false;
        } else{
        	if($("#chkOkId").val() != $("#userId").val() || result == 0){
        		alert('아이디를 중복 검사해주세요.');
        		return false;
        	}
    } 
    
};

function agree_chk(){
	//onclick은 체크할때 체크를 해제할때 모두 호출되기때문에 호출여부를 확인해야한다.
	if(join.agree_all.checked==true){
	join.agree_use.checked=true;
	join.agree_personal.checked=true;
 }else{
		join.agree_use.checked=false;
		join.agree_personal.checked=false;
 }//else닫기
	}//함수닫기
	
	
$(document).ready(function () {
    //이메일 domain선택 selectBox
 $('#domainSelectBox').change(function(){

  $("#domainSelectBox option:selected").each(function () {
  //직접입력일 경우
  if($(this).val()== 'self'){

      $("#userMail2").val('');                             //textBox값 초기화

      $("#userMail2").attr("disabled",false);    //textBox 활성화

  }
  else if($(this).val()== 'select'){
              //선택(초기값)일 경우
      $("#userMail2 ").val('');                          //textBox값 초기화

      $("#userMail2 ").attr("disabled",false); //textBox 활성화
  }

  else{

    $("#userMail2").val($(this).text());      //selectBox에서 선택한 값을 textBox에 입력

    $("#userMail2").attr("disabled",true); //textBox 비활성화

  	}

  });

});

});
