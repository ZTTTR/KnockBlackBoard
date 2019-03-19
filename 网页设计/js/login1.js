
var vu=new Vue({
    el:'#bicode_box',
    data:{
        data:[],

        topic_message:"敲黑板",
        prompt_message:"请扫描二维码登录",
        icont:"../images/QRcode.jpg",
    }
});
new Vue({
    el:'#topic',
    data:{
        data:[],
        topic_message:"敲黑板",
    }
})