//增加一行
var nowsrow=1;
function addRow() {
    var varrow=document.getElementById('login_information').insertRow(nowsrow);

    var one=varrow.insertCell(0);
    var two=varrow.insertCell(1);
    var three=varrow.insertCell(2);
    var four=varrow.insertCell(3);
    one.innerHTML=nowsrow;

    //添加学号
    two.innerHTML="NEW CELL2";
    //添加名字
    three.innerHTML="NEW CELL2";
    var d=new Date();
    four.innerHTML=d.getHours()+":"+d.getMinutes();
    nowsrow=nowsrow+1;

    //滑动条最底下
    varrow.scrollTop = varrow.scrollHeight;
}
function addTbody(oTbody){

    var oTable = document.getElementById('login_information');
    //创建tbody
    var oTbody = oTable.tbody;
    //  document.createElement("tbody");

    var tr = document.createElement("tr");
    var one=document.createElement("td");      //新建一个td类型的Element节点
    var two=document.createElement("td");
    var three=document.createElement("td");
    var four=document.createElement("td");
    one.innerHTML = nowsrow;
    tr.appendChild(one);
    two.innerHTML = "NEW CELL2";
    tr.appendChild(two);
    three.innerHTML = "NEW CELL3";
    tr.appendChild(three);
    var d=new Date();
    four.innerHTML =d.getHours()+":"+d.getMinutes();

    tr.appendChild(four);
    oTbody.appendChild(tr);
    oTable.appendChild(oTbody);


    nowsrow=nowsrow+1;
}
//添加聊天信息
function addMessage() {
    window.location.href="./myclass.html";
    var varrow=document.getElementById('chatBox');
    //构建messagebox

    //用户信息
    var user=document.createElement("div");
    user.setAttribute("class","user");
    user.innerHTML='<img src="../images/head2.jpg"  style="max-height: 100%;max_with:100%;">';
    //聊天信息
    var messagetext=document.createElement("div");
    messagetext.setAttribute("class","messagetext");

    //信息内容
    messagetext.innerHTML="111";
    //获取时间
    var messagetime=document.createElement("span");
    messagetime.setAttribute("class","messagetime");
    var d=new Date();
    //名称+时间
    messagetime.innerHTML="孔庆莱 20:11";

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
function ShowAndHide() {
    var div1=document.getElementById("output");
    if(div1.style.display=='block') div1.style.display='none';
    else div1.style.display='block';
}
self.setInterval("refresh()",1000);
function refresh() {
    var temp=document.createElement("div");
    var date=new Date();
    jQuery(function(){
        //二维码内容
        var edit="http://www.w3school.com.cn/jsref/jsref_split.asp"+"/"+date.getTime();
        jQuery(temp).qrcode(edit);
    })
    var control=document.getElementById('control');
    var now=document.getElementById('output');
    $("#output").empty();
    output.appendChild(temp);
}
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