/**
 * Created by st0001 on 2017/12/13.
 * added on 2017/12/16
 */

$().ready(function() {
    $("#register_form").validate({
        rules: {
            rUsername: "required",
            rPassword: {
                required: true,
                minlength: 5
            },
            rConfirmPassword: {
                required: true,
                equalTo: "#exampleInputPassword1"
            },
            rEmail: {
                required: true,
                email: true
            },
            rCode:"required"
        },
        messages: {
            rUsername: "请输入姓名",
            rPassword: {
                required: "请输入密码",
                minlength: "密码不能小于{0}个字符"
            },
            rConfirmPassword: {
                required: "请再次输入密码",
                equalTo: "两次密码不一样"
            },
            rEmail: {
                required: "请输入手机号码",
                email: "请输入有效手机号码"
            },
            rCode:{
                required: "请输入验证码"
            }
        }
    });
    
});


var sleep = 30, interval = null;
window.onload = function ()
{
    var btn = document.getElementById ('getCode');
    btn.onclick = function ()
    {
        var email = document.getElementById("exampleInputEmail1").value;
        var reg=/^[1][3,4,5,7,8][0-9]{9}$/;
        if(email.length==0)
            toastr.warning("请输入手机号码");
        else if(!reg.test(email))
            toastr.warning("请输入有效手机号码");
        
        if (!interval&&email.length!=0&&reg.test(email)){
        	console.log(email);
            $.ajax({
            	type:"POST",
            	contentType:'application/json',
            	//获取验证码的url
            	url:"/getCode",
            	data:JSON.stringify({
            		"tele":email
            	}),
            	dataType:"json",
            	success:function(data){
            		console.log(data);
            		toastr.info("请查看手机验证码");
					
            	}
            })
            this.style.backgroundColor = 'rgb(243, 182, 182)';
            this.disabled = "disabled";
            this.style.cursor = "wait";
            this.value = "重新发送 (" + sleep-- + ")";
            interval = setInterval (function ()
            {
                if (sleep == 0)
                {
                    if (!!interval)
                    {
                        clearInterval (interval);
                        interval = null;
                        sleep = 30;
                        btn.style.cursor = "pointer";
                        btn.removeAttribute ('disabled');
                        btn.value = "获取验证码";
                        btn.style.backgroundColor = '';
                    }
                    return false;
                }
                btn.value = "重新发送 (" + sleep-- + ")";
            }, 1000);            
        }
    }
}

$("#register").click(function(){
	var username = $("#exampleInputName").val();
	var userpassword = $("#exampleInputPassword1").val();
	var usertele = $("#exampleInputEmail1").val();
	var usercode = $("#exampleCode").val();
	var type=$(':radio:checked').val();
	
	//验证码验证
	//在前端实现不安全，需要在后端实现
	$.ajax({
		type:"POST",
		contentType:'application/json',
		//验证url
		url: "/validate",
		data:JSON.stringify({
			"tele":usertele,
			"code":usercode
		}),
		dataType:"json",
		timeout:15000,
		success: function(data){
			
			console.log(data);
            var status = data.result;
            if (status == "error") {
				toastr.error("验证失败！");
			}else if (status == "success") {
				//验证成功后
				if (type=="user") {
					//普通用户的注册
					$.ajax({
						type:"POST",
						contentType:'application/json',
						//
						url: "/usersignup",
						data:JSON.stringify({
							"username":username,
							"password":userpassword,
							"tele":usertele,
							"role":type
						}),
						dataType:"json",
						timeout:15000,
						success: function(data){
							console.log(data);
				            var status = data.result;
				            if (status == "error") {
								toastr.error("注册失败！");
							}else if (status == "success") {
								window.location = "/login";
							}
						}
					})
				}else {
					//商业用户的注册
					$.ajax({
						type:"POST",
						contentType:'application/json',
						//
						url: "/salersignup",
						data:JSON.stringify({
							"username":username,
							"password":userpassword,
							"tele":usertele,
							"role":type
						}),
						dataType:"json",
						timeout:15000,
						success: function(data){
							console.log(data);
				            var status = data.result;
				            if (status == "error") {
								toastr.error("注册失败！");
							}else if (status == "success") {
								window.location = "/login";
							}
						}
					})
				}
				
//				window.location = "/login";
			}
		}
	})
	
})