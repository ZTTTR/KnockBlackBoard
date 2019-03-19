new Vue({
    el:"#app",
    data:{
        courseName:'高等数学',
        class_student:[{name:'张三丰',school_number:100,answer:30,online_time:500,blackboard_number:24}],
        class_file:[{name:'第一章极限的求解.ppt',time:'2018/07/15',frequency:25,size:3.56},
            {name:'第二章向量的求解.ppt',time:'2018/07/17',frequency:25,size:4.33},
        ],
        class_notic:[{topic:'第1周作业',content:'自学第一章关于极限的内容，并完成所有课后习题',time:'2018/07/18'}],
        class_problem:[
            {topic:'鸡兔同笼问题',content:'老师好，有若干只鸡和兔子，它们共有88个头，244只脚，鸡和兔各有多少只？',time:'2018/07/03',classid:'2',publicornot:false,reply:'',reply_show:false},
            {topic:'幂级数',content:'求幂级数n！x^n的收敛半径（n从0到无穷）',time:'2018/07/03',reply:'',reply_show:false}],
        myCourse:[],
        class_phone:13,
        number:-1,
        now_fountion:1,
        class_head_image_path:"../images/classone/course_image.jpg",
        class_image_list: [],
        userName:"",
        size: 0,
    },
    created :function () {
        this.Initialization();
    },
    methods:{
        Initialization:function () {

            var formObject={};
            var uid=window.localStorage.getItem("uid");   //获取uid
            formObject["uid"]=uid;
            this.userName=window.localStorage.getItem("userName");
            this.courseName=window.localStorage.getItem("courseName");
            this.getNotic();
        },
        add:function (number) {
          this.option.push(number);
        },
        getLocalTime:function (date) {
            var tempDate=new Date(parseInt(date));

            return tempDate.getFullYear()+"/"+tempDate.getMonth()+"/"+tempDate.getDate();
        },
        setFountion:function (n) {
            this.now_fountion=n;
            if(n==1){
                this.getNotic();
            }
            if(n==2){
                this.getProblem();
            }
            if(n==3){
                this.getFile();
            }
            if(n==4){
                this.getPhoto();
            }
            if(n==5){
                this.getCoureData();
            }
            if(n==6){
                this.startClass();
            }
        },
        getNotic:function () {
            var formObject={};
            formObject["uid"]=window.localStorage.getItem("uid");;//从本地存储中获取uid
            formObject["courseId"]=window.localStorage.getItem("courseId"); //从本地存储中获取courseId
            formObject["classId"]=window.localStorage.getItem("classId"); //从本地存储中获取classId
            var formJson = JSON.stringify(formObject);
            var _this=this;
            // alert(formJson);
            $.ajax({
                type : "POST",
                url : "http://127.0.0.1:8080/CourseNote/getInfo",
                data:formJson,
                contentType:"text/plain",
                success : function(data,status) {
                     if(data!=null){
                         for(var item in data)
                         {
                             _this.class_notic.push({
                                 courseNoteId:item.courseNoteId,
                                 topic:item.title,
                                 content:item.content,
                                 time:_this.getLocalTime(item.time),
                             })
                         }
                     }
                    //只要alert能显示出要得到的数据就好
                    alert(data);     //显示得到的数据和课堂状态
                    // var message = $.parseJSON(data);//后台返回的json数据需要转为对象
                    // vue.selectById=message;//把后台返回的JSON数据赋给selectById
                },
                error : function(){
                    // alert("获取公告数据错误");
                }
            });
        },
        getProblem:function(){
            var formObject={};
            formObject["uid"]=window.localStorage.getItem("uid");;//从本地存储中获取uid
            formObject["courseId"]=window.localStorage.getItem("courseId"); //从本地存储中获取courseId
            formObject["classId"]=window.localStorage.getItem("classId"); //从本地存储中获取classId
            var formJson = JSON.stringify(formObject);
            // alert(formJson);
            $.ajax({
                type : "POST",
                url : "http://10.242.0.115:8080/StudentQuestionDaoServlet?method=getStudentQuestion",
                data:formJson,
                contentType:"text/plain",
                success : function(data,status) {

                    for(var item in data)
                    {
                        this.class_problem.push({
                            topic:item.title,
                            content:item.content,
                            reply:item.reply,
                            publicornot:item.publicornot,
                            classid:item.classid,
                            time:this.getLocalTime(item.time)
                        })
                    }
                    //只要alert能显示出要得到的数据就好
                    alert(data+status);     //显示得到的数据和课堂状态
                    // var message = $.parseJSON(data);//后台返回的json数据需要转为对象
                    // vue.selectById=message;//把后台返回的JSON数据赋给selectById
                },
                error : function(){
                    // alert("获取公告数据错误");
                }
            });
        },
        getFile:function () {

        },
        getPhoto:function () {

        },
        getCoureData:function () {

        },
        startClass:function (name,time,) {
            window.location.href="./classing.html";
        },
        reply:function () {
            this.class_problem[0].reply='回复：小学问题，自己百度';
        },
        addNotic:function(){
            // this.class_notic.push({
            //     topic: $("#topic").val(),
            //     content: $("#content").val(),
            //     time: '2018/7/20',
            // });
            var formObject = {};
            var formArray =$("#notic_form").serializeArray();
            $.each(formArray,function(i,item){
                formObject[item.name] = item.value;
            });
            formObject["courseId"]=window.localStorage.getItem("courseId");
            formObject["time"]=new Date().getTime();
            var formJson = JSON.stringify(formObject);

            $.ajax({
                type : "POST",
                url : "http://10.243.1.30/CourseNoteServlet?method=createCourseNote",
                data:formJson,
                contentType:"text/plain",
                success : function(data,status) {
                    this.class_notic.push({
                        topic:formJson.topic,
                        content:formJson.content,
                        time:formJson.time,
                    })
                    // alert(data+status);
                },
                error : function(){
                    alert("添加失败");
                }
            });
        },
        replyProblem:function(){

        },
        addClassFile:function (name,time,) {

        },
        openPerson:function () {
            window.location.href="./persondata.html";
        },


        showReply:function(class_problem){
            class_problem.reply_show=!class_problem.reply_show;
        },
        up_click:function() {
            vm.$refs['file_up'].click();
        },
        // 文件上传
        up_change: function (event) {
            vm.data.reason_file = event.target.files[0]
            // console.log(vm.data);
        },
        fileClick(){
            document.getElementById('upload_file').click()
        },
        fileChange(el){
            if (!el.target.files[0].size) return;
            this.fileList(el.target.files);
            el.target.value = ''
        },
        fileList(files){
            for (let i = 0; i < files.length; i++) {
                this.fileAdd(files[i]);
            }
        },
        fileAdd(file){
            this.size = this.size + file.size;//总大小
            let reader = new FileReader();
            reader.vue = this;
            reader.readAsDataURL(file);
            reader.onload = function () {
                file.src = this.result;
                this.vue.class_image_list.push({
                    file
                });
            }
        },
        fileDel(index){
            this.size = this.size - this.class_image_list[index].file.size;//总大小
            this.class_image_list.splice(index, 1);
        },
        bytesToSize(bytes){
            if (bytes === 0) return '0 B';
            let k = 1000, // or 1024
                sizes = ['B', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'],
                i = Math.floor(Math.log(bytes) / Math.log(k));
            return (bytes / Math.pow(k, i)).toPrecision(3) + ' ' + sizes[i];
        },
        dragenter(el){
            el.stopPropagation();
            el.preventDefault();
        },
        dragover(el){
            el.stopPropagation();
            el.preventDefault();
        },
        drop(el){
            el.stopPropagation();
            el.preventDefault();
            this.fileList(el.dataTransfer.files);
        },

    }
})
