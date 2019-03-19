$(function () {

    $('#switch_qlogin').click(function () {
        $('#switch_login').removeClass("switch_btn_focus").addClass('switch_btn');
        $('#switch_qlogin').removeClass("switch_btn").addClass('switch_btn_focus');
        $('#switch_bottom').animate({left: '0px', width: '70px'});
        $('#qlogin').css('display', 'none');
        $('#web_qr_login').css('display', 'block');

    });
    $('#switch_login').click(function () {

        $('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
        $('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
        $('#switch_bottom').animate({left: '154px', width: '70px'});

        $('#qlogin').css('display', 'block');
        $('#web_qr_login').css('display', 'none');
    });
    if (getParam("a") == '0') {
        $('#switch_login').trigger('click');
    }

});

function logintab() {
    scrollTo(0);
    $('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
    $('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
    $('#switch_bottom').animate({left: '154px', width: '96px'});
    $('#qlogin').css('display', 'none');
    $('#web_qr_login').css('display', 'block');

}


//根据参数名获得该参数 pname等于想要的参数名
function getParam(pname) {
    var params = location.search.substr(1); // 获取参数 平且去掉？
    var ArrParam = params.split('&');
    if (ArrParam.length == 1) {
        //只有一个参数的情况
        return params.split('=')[1];
    }
    else {
        //多个参数参数的情况
        for (var i = 0; i < ArrParam.length; i++) {
            if (ArrParam[i].split('=')[0] == pname) {
                return ArrParam[i].split('=')[1];
            }
        }
    }
}

$("#login_submit").click(function () {
    // window.localStorage.setItem("uid", "25");   //在浏览器中存储uid
    // window.location.href="./myclass.html";
    // console.log($.parseJSON(formJson))
    var formObject = {};
    var formArray =$("#login_form").serializeArray();
    $.each(formArray,function(i,item){
        formObject[item.name] = item.value;
    });
    var formJson = JSON.stringify(formObject);
    var ure=encodeURI("http://127.0.0.1:8080/User/login");

    $.ajax({
        url:ure,
        type:"post",
        data:formJson,
        contentType:"text/plain",
        success: function (data, status) {
            if(data=="error"){
                alert("账户密码错误");
            }else {
                window.sessionStorage.setItem("uid", data.uid);   //在浏览器中存储uid
                window.location.href = "./myclass.html";
            }
            // window.sessionStorage.setItem("username",("#u").val())
        },
        error: function (data, status) {
            alert("登录出错\n"+"数据: \n" + data + "\n状态: " + status);
        }
    })
});
$('#reg').click(function () {

    var formObject = {};
    var formArray =$("#regUser").serializeArray();
    $.each(formArray,function(i,item){
        formObject[item.name] = item.value;
    });

    var formJson = JSON.stringify(formObject);
    if ($('#user').val() == "") {
        $('#user').focus().css({
            border: "1px solid red",
            boxShadow: "0 0 2px red"
        });
        $('#userCue').html("<font color='red' size='0.5px'><b>×用户名不能为空</b></font>");
        return false;
    }
    if ($('#user').val().length < 4 || $('#user').val().length > 16) {

        $('#user').focus().css({
            border: "1px solid red",
            boxShadow: "0 0 2px red"
        });
        $('#userCue').html("<font color='red'><b>×用户名位4-16字符</b></font>");
        return false;
    }
    if ($('#passwd').val().length < 6) {
        $('#passwd').focus();
        $('#userpasswardCue').html("<font color='red'><b>×密码不能小于" + 6 + "位</b></font>");
        return false;
    }
    if ($('#passwd2').val() != $('#passwd').val()) {
        $('#passwd2').focus();
        $('#userpasswardCue2').html("<font color='red'><b>×两次密码不一致！</b></font>");
        return false;
    }
    // var sqq = /^[1-9]{1}[0-9]{4,9}$/;!sqq.test($('#email').val()) ||
    if ( $('#email').val().length < 5 || $('#email').val().length > 18) {
        $('#email').focus().css({
            border: "1px solid red",
            boxShadow: "0 0 2px red"
        });
        $('#userCue').html("<font color='red'><b>×邮箱格式不正确</b></font>");
        return false;
    } else {
        $('#email').css({
            border: "1px solid #D7D7D7",
            boxShadow: "none"
        });
    }

    $.ajax({
        type:"post",
        url: "http://127.0.0.1:8080/User/register",
        data:formJson,
        contentType:"text/plain",
        success:  function (data, status) {
            if(data=="successful"){
                alert("注册成功，请填写个人信息");
                window.sessionStorage.setItem("uid", formObject.uid);   //在浏览器中存储uid
                window.sessionStorage.setItem("userName",formObject.username);
                window.location.href="./persondata.html"

            }else {
                alert("注册失败");
            }
            // window.sessionStorage.setItem("username",("#u").val())
            // records=JSON.stringify(records); //JSON.stringify装换成json
        },
        default: function () {
            alert("错误")
        }
    });
    // $('#regUser').submit();
});
