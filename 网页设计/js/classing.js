$(function() {
    function setCurrentSlide(ele, index) {
        $(".swiper1 .swiper-slide").removeClass("selected");
        ele.addClass("selected");
        //swiper1.initialSlide=index;
    }

    var swiper1 = new Swiper('.swiper1', {
//					设置slider容器能够同时显示的slides数量(carousel模式)。
//					可以设置为number或者 'auto'则自动根据slides的宽度来设定数量。
//					loop模式下如果设置为'auto'还需要设置另外一个参数loopedSlides。
        slidesPerView: 5.5,
        paginationClickable: true,//此参数设置为true时，点击分页器的指示点分页器会控制Swiper切换。
        spaceBetween: 10,//slide之间的距离（单位px）。
        freeMode: true,//默认为false，普通模式：slide滑动时只滑动一格，并自动贴合wrapper，设置为true则变为free模式，slide会根据惯性滑动且不会贴合。
        loop: false,//是否可循环
        onTab: function(swiper) {
            var n = swiper1.clickedIndex;
        }
    });
    swiper1.slides.each(function(index, val) {
        var ele = $(this);
        ele.on("click", function() {
            setCurrentSlide(ele, index);
            swiper2.slideTo(index, 500, false);
            //mySwiper.initialSlide=index;
        });
    });

    var swiper2 = new Swiper('.swiper2', {
        //freeModeSticky  设置为true 滑动会自动贴合
        direction: 'horizontal',//Slides的滑动方向，可设置水平(horizontal)或垂直(vertical)。
        loop: false,
//					effect : 'fade',//淡入
        //effect : 'cube',//方块
        //effect : 'coverflow',//3D流
//					effect : 'flip',//3D翻转
        autoHeight: true,//自动高度。设置为true时，wrapper和container会随着当前slide的高度而发生变化。
        onSlideChangeEnd: function(swiper) {  //回调函数，swiper从一个slide过渡到另一个slide结束时执行。
            var n = swiper.activeIndex;
            setCurrentSlide($(".swiper1 .swiper-slide").eq(n), n);
            swiper1.slideTo(n, 500, false);
        }
    });
});

//增加一行
var nowsrow=1;
function addRow(Message) {
    var varrow=document.getElementById('login_information').insertRow(nowsrow);
    var message = $.parseJSON(Message);
    var one=varrow.insertCell(0);
    var two=varrow.insertCell(1);
    var three=varrow.insertCell(2);
    var four=varrow.insertCell(3);
    one.innerHTML=nowsrow;

    //添加学号
    two.innerHTML=message.userName;
    //添加名字
    three.innerHTML=message.schoolId;
    var d=new Date();
    four.innerHTML=d.getHours()+":"+d.getMinutes();
    nowsrow=nowsrow+1;

    //滑动条最底下
    varrow.scrollTop = varrow.scrollHeight;
}

//添加聊天信息
function addMessage(Message) {
    window.location.href="./myclass.html";
    var varrow=document.getElementById('chatBox');
    var message = $.parseJSON(Message);
    //构建messagebox

    //用户信息
    var user=document.createElement("div");
    user.setAttribute("class","user");
    switch (message.userName){
        case "许博勇":
            user.innerHTML='<img src="../../images/head1.jpg"  style="max-height: 100%;max_with:100%;">'+"许博勇";
            break;
        case "孔庆莱":
            user.innerHTML='<img src="../../images/head2.jpg"  style="max-height: 100%;max_with:100%;">'+"孔庆莱";
            break;
        case "周锐良":
            user.innerHTML='<img src="../../images/head3.jpg"  style="max-height: 100%;max_with:100%;">'+"周锐良";
            break;
        case "周韬锐":
            user.innerHTML='<img src="../../images/head4.jpg"  style="max-height: 100%;max_with:100%;">'+"周韬锐";
            break;
        case "张健欣":
            user.innerHTML='<img src="../../images/head5.jpg"  style="max-height: 100%;max_with:100%;">'+"张健欣";
            break;
        default :
            user.innerHTML='<img src="../../images/head2.jpg"  style="max-height: 100%;max_with:100%;">'+"孔庆莱";
            break;
    }
    //聊天信息
    var messagetext=document.createElement("div");
    messagetext.setAttribute("class","messagetext");
    messagetext.innerHTML= message.message;
    //获取时间
    var messagetime=document.createElement("span");
    messagetime.setAttribute("class","messagetime");
    var d=new Date();
    messagetime.innerHTML=d.getHours()+":"+d.getMinutes();

    //聊天框
    var messagebox=document.createElement("div");
    messagebox.setAttribute("class","messagebox");
    messagebox.appendChild(user);
    //将时间加入聊天信息中
    messagebox.appendChild(messagetime);
    messagebox.appendChild(messagetext);
    //将聊天框显示
    varrow.appendChild(messagebox);
    //滑动条最底下
    varrow.scrollTop = varrow.scrollHeight;

    /*
    varrow.appendChild(nameandtime);
    */
}
//jdk.internal.dynalink.support.AbstractCallSiteDescriptor
//显示和隐藏二维码
function ShowAndHide() {
    var div1=document.getElementById("output");
    if(div1.style.display=='block') div1.style.display='none';
    else div1.style.display='block';
}

var websocket = null;
websocket = new WebSocket("${basePath}${classId}");
//setMessageInnerHTML("ws://localhost:8080/webSocket/onClass/${classId}");
//websocket = new WebSocket("ws://5108c29d.nat123.net:54515/webSocket/onClass/${classId}");
//setMessageInnerHTML("ws://5108c29d.nat123.net:54515/webSocket/onClass/${classId}");
//连接发生错误的回调方法
websocket.onerror = function () {
    //setMessageInnerHTML("error");
};

//连接成功建立的回调方法
websocket.onopen = function (event) {
    //setMessageInnerHTML("open");
}

//接收到消息的回调方法
websocket.onmessage = function (event) {
    setMessageInnerHTML(event.data);
}

//连接关闭的回调方法
websocket.onclose = function () {
    //setMessageInnerHTML("close");
}

//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
window.onbeforeunload = function () {
    websocket.close();
}

function setMessageInnerHTML(Message) {
    var message = $.parseJSON(Message);
    if(message.schoolId == "")
        addMessage(Message);
    else
        addRow(Message);
    //var varrow=document.getElementById('chatBox');
    //var messagetext=document.createElement("div");
    //messagetext.setAttribute("class","messagetext");
    //messagetext.innerHTML=Message;
    //varrow.appendChild(messagetext);
}

//关闭连接
function closeWebSocket() {

    var closeJson = {"isStudent": false, "message": "close", "classId":11};
    //setMessageInnerHTML(JSON.stringify(closeJson));
    websocket.send(JSON.stringify(closeJson));
    websocket.close();

    window.location.href = 'hasEndClass.jsp';
}

websocket.onclose = function () {
        //setMessageInnerHTML("close");
}