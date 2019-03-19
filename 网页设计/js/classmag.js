window.onload=function(){
    var username=sessionStorage.getItem("username");
    alert(sessionStorage.getItem("username"));

}
var vm=new Vue( {
    el:"#mainbox",
    data:{
        data:[],
        fountion_index:0,
        now_fountion_index:1,
    },
    methods:{
        setTab:function (n) {
            this.now_fountion_index=n;
        }
    }
})
new Vue({
    el:"#classbox",
    data:{
        class_data:[{class_name:'信息技术', people_number:50, create_time:1532153, class_images_path:"../images/computer_information.jpg"},{class_name:'信息技术', people_number:50, create_time:1532153, class_images_path:"../images/computer_information.jpg"}],
        class_name:'信息技术',
        people_number:50,
        create_time:1532153,
        class_images_path:"../images/computer_information.jpg",
        showimg:1,
        showbtn:0,
    },
    methods:{
        enter:function () {
            this.showbtn=1;
            this.showimg=0;
        },
        leave:function(){
            this.showbtn=0;
            this.showimg=1;
        }
    }
})
