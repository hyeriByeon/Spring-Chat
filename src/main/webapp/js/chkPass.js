

	function check(){

		if($("#userPw").val() != null){
			var query = {
				userPw : $("#userPw").val()
			};// varQuery
			
			$.ajax({
				type : "get",
				url : "/chkPass",
				data : query,//para 1/ -1
				
				success:function(data){
					if(data == 1){//패스워드가 일치하면
						
						alert('정상적으로 완료되었습니다.');
						$(".passResult").text("패스워드가 일치합니다.");
						var mail = '@';
						
						$('#userMail_check').val($('#userMail1').val() + mail + $('#userMail2').val());
						$("#actionForm").submit();
						
						return true;
					}else if(data == -1){
						$(".passResult").text("패스워드가 일치하지 않습니다.");
						$("#userPw").focus();
						return false;
					}
				}//success
			});//ajax	
		}else{
			alert('패스워드를 확인해주세요.');
		}	
	}
	
	function userdel(){
		var fun = prompt('패스워드를 입력하세요!');
		
		if(fun != null){
			var query = {
				userPw : fun
			};// varQuery
			
			$.ajax({
				type : "get",
				url : "/chkPass",
				data : query,//para 1/ -1
				
				success:function(data){
					if(data == 1){//패스워드가 일치하면
						alert('패스워드가 일치합니다.');
						
						location.replace('/user/deleteUser');
						return true;
					}else if(data == -1){
						alert('패스워드가 일치하지 않습니다.');
						return false;
					}
				}//success
			});//ajax	
		}	
	}