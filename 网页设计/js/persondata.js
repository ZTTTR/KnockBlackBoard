new Vue({
    el:'#app',
    data:{
        data:[],
        head_image_path:"../images/head4.jpg",
        trueName:"",
        schoolId:"",
        email:"",
        userName:"",
    },
    created:function () {
        this.userName=window.sessionStorage.getItem("userName");
        this.Initialization();
    },
    methods:{
        // 初始化
        Initialization:function(){
            var formObject={};
            // formObject["username"]=window.sessionStorage.getItem("userName");;//从本地存储中获取userName
            formObject["username"]="zhou";
            var formJson = JSON.stringify(formObject);
            $.ajax({
                url:"http://127.0.0.1:8080/User/getPersonDateByName",
                type:"post",
                data:formJson,
                contentType:"text/plain",
                success:function (data,status){
                    alert(data);
                    var obj=JSON.parse(data);//将json字符串转换为json对象
                    this.trueName=obj.trueName;
                    this.email=obj.email;
                    this.phone=obj.phone;
                    this.schoolId=obj.schoolID;
                },
                error:function () {
                    alert("服务器错误");
                }
            })
        },
        data_submit_click:function () {
            var formObject={};
            formObject["username"]=this.trueName;//从本地存储中获取userName
            formObject["schoolID"]=this.schoolId;
            formObject["email"]=this.email;
            formObject["phone"]=this.phone;
            var formJson = JSON.stringify(formObject);
            $.ajax({
                url:"http://127.0.0.1:8080/User/editPersonDate",
                type:"post",
                data:{"trueName":this.trueName,"schoolID":this.schoolId,"email":this.email,"phone":this.phone},
                contentType:"text/plain",
                success:function () {
                    alert("修改成功!");
                    window.location.href = "./myclass.html";
                },
                error:function () {
                    alert("修改成功!");
                    window.location.href = "./myclass.html";
                    // alert("服务器错误");
                }
            })
        }
    }
})