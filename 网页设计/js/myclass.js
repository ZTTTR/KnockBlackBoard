window.onload = function() {
    var Vm=new Vue({
        el: "#myclass_table",
        data ()  {
            return {
                myData: [],
                result: [],
                CourseName: "",
                PeopleNumber: "",
                CreatTime: "",
                nowIndex: -100,
                // index: 0,
                delete_icon: "../images/Delete.png"
            }
        },
        created: function () {
            this.Initialization();
        },
        methods: {
            //初始化
            Initialization: function () {

                // this.result = [{
                //     "courseId": 1,
                //     "courseName": "高等数学",
                //     "peopleNumber": 3,
                //     "creatTime": "2018-7-13 9：55"
                // }, {"courseId": 2, "courseName": "信息技术", "peopleNumber": 1, "creatTime": "2018-7-14 14：50"}];
                // for (var i in this.result) {
                //     this.addCourse(this.result[i].courseId, this.result[i].courseName, this.result[i].peopleNumber, this.result[i].creatTime);
                // }

                var formObject = {};
                //从本地缓存中获取uid
                window.localStorage.setItem("uid","111");
                formObject["uid"] = window.localStorage.getItem("uid");   //获取uid
                var formJson = JSON.stringify(formObject);
                var _this=this;
                $.ajax({
                    type : "POST",
                    url : "http://127.0.0.1:8080/Course/getInfoById",
                    data:formJson,
                    contentType:"text/plain",
                    dataType:"text",
                    success : function(data,status) {
                        var datajson=JSON.parse(data);
                        for(var i in datajson){
                            //设置

                            _this.myData.push({  //this指向不同
                                CourseId: datajson[i].courseId,
                                CourseName: decodeURI(datajson[i].courseName),//转码
                                PeopleNumber: datajson[i].peopleNumber,
                                CreatTime:_this.setDataFomat(datajson[i].createTime),
                            })
                            // alert(datajson[i].courseName);
                            // this.addCourse(datajson[i].courseId,datajson[i].courseName,datajson[i].peopleNumber,datajson[i].creatTime);
                        }
                    },
                    error : function(){
                        // alert("获取数据失败");
                    }
                });
            },
            addCourse: function (courseId, courseName, peopleNumber, creatTime) {
                this.myData.push({
                    CourseId: courseId,
                    CourseName: courseName,
                    PeopleNumber: peopleNumber,
                    CreatTime: creatTime,
                })
                // alert(this.myData.toString());
            },
            creatCourse:function () {
                var formObject={};
                // formObject["courseId"]=this.myData.length+1;
                formObject["uid"]="111";
                // formObject["uid"]=window.localStorage.getItem("uid");
                formObject["courseName"]= $("#coureName").val();
                formObject["createTime"]=new Date().getTime();
                formObject["peopleNumber"]=0;
                var formJson = JSON.stringify(formObject);
                // alert(formJson);
                var _this=this;
                $.ajax({
                    type : "POST",
                    url : "http://127.0.0.1:8080/Course/create",
                    data:formJson,
                    contentType:"text/plain",
                    success : function(data,status) {
                        _this.addCourse(formObject.courseId,formObject.courseName,formObject.peopleNumber,formObject.creatTime);
                        // var message = $.parseJSON(data);//后台返回的json数据需要转为对象
                        // vue.selectById=message;//把后台返回的JSON数据赋给selectById
                    },
                    error : function(){
                        // alert("错误");
                    }
                });
            },
            course_in: function (n) {
                window.localStorage.setItem("uid", window.localStorage.getItem("uid"));
                // window.localStorage.setItem("courseId", this.myData[index].CourseId);
                // window.localStorage.setItem("courseName", this.myData[index].CourseName);
                window.location.href = "./classone.html";
            },
            delete_course: function (n) {
                if (n == -2) {
                    this.myData =[];
                }
                else{
                    var formObject={};
                    formObject["courseId"]=this.myData[n].CourseId;
                    var formJson=JSON.stringify(formObject);
                    var _this=this;
                    $.ajax({
                        type:"POST",
                        url:"http://127.0.0.1:8080/Course/delete",
                        data:formJson,
                        contentType:"text/plain",
                        success:function (data,status) {
                            if(data=="ok"){
                                _this.myData.splice(n, 1);
                            }

                        },
                        default:function () {

                        }
                    });
                }
            },
            setDataFomat:function (date) {
                console.log(date);

                var nowDate=new Date(parseInt(date));
                console.log(nowDate);
                var  nowDateString= String(nowDate.getFullYear()+"-" +
                    parseInt(nowDate.getMonth()+1)+"-" +
                    nowDate.getDate()+" " +
                    nowDate.getHours()+":"+
                    nowDate.getMinutes()+":"+
                    nowDate.getSeconds());
                console.log(nowDateString);
                return nowDateString;
            }
        },

    })
}
