		function validate_username(){
			var username = document.getElementById("username");
			var name_ele = document.getElementById("username_ele");
			if(username == ""){
				name_ele.innerHTML="<font color='red'>X Can't be empty</font>";
				return false;
			}else{
				name_ele.innerHTML="<font color='green'>Valid username</font>";
				return true;
			}
		}
		function validate_password(){
			var password = document.getElementById("password");
			var password_ele = document.getElementById("password_ele");
			if(password ==""){
				password_ele.innerHTML="<font color='red'>X Can't be empty</font>";
				return false;
			}else{
				password_ele.innerHTML="<font color='green'>Valid password</font>";
				return true;
			}

		}

		function validate_address(){
			var address = document.getElementById("address");
			var address_ele = document.getElementById("address_ele");
			if(address ==""){
				address_ele.innerHTML="<font color='red'>X Can't be empty</font>";
				return false;
			}else{
				address_ele.innerHTML="<font color='green'>Valid</font>";
				return true;
			}

		}


		function confirm_passwords(){
			var password = document.getElementById("password");
			var confirm_password = document.getElementById("confirm_password");
			var pw_ele = document.getElementById("pw_ele");
			if(confirm_password == ""){
				pw_ele.innerHTML="<font color='red'>X Can't be empty</font>";
				return false;
			}else{
				if(password != confirm_password){
					pw_ele.innerHTML="<font color='red'>X Different password</font>";
					return false;
				}else{
					pw_ele.innerHTML="<font color='green'>Password confirmed</font>";
					return true;
				}
			}
		}


		function validate_tel(){
			var tel = document.getElementById("tel");
			var tel_ele = document.getElementById("tel_ele");
			if(tel == ""){
				tel_ele.innerHTML="<font color='red'>X Can't be empty</font>";
				return false;
			}else{

				var patrn=/^0{0,1}(13[0-9]|15[7-9]|153|156|18[7-9])[0-9]{8}$/;
				if(!patrn.exec(tel)){
					tel_ele.innerHTML="<font color='red'>X Invalid phone number</font>";
					return false;
				}else{
					tel_ele.innerHTML="<font color='green'>Valid</font>";
					return true;
				}
			}

		}
		function validate_email(){
			var email =document.getElementById("email");
			var email_ele = document.getElementById("email_ele");
			if(email == ""){
				email_ele.innerHTML="<font color='red'>X Can't be empty</font>";
				return false;
			}else{
				var patrn=/^[a-zA-Z0-9_+.-]+\@([a-zA-Z0-9-]+\.)+[a-zA-Z0-9]{2,4}$/;
				if(!patrn.test(email)){
					email_ele.innerHTML="<font color='red'>X Invalid</font>";
					return false;
				}else{
					email_ele.innerHTML="<font color='green'>Valid</font>";
					return true;
				}
			}
		}
		function check_form(){
			return validate_username()&&validate_email()&&validate_password()&&confirm_passwords()&&validate_tel();
		}
