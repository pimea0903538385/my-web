let app=new Vue({
    el:"#app",
    data:{
        userNickname:'',
        password:'',
        string:''
    },methods:{
        login:function (){
           let data={
               userNickname: this.userNickname,
               password: this.password
           }

            let _this=this;
            $.ajax({
              url:"/login",
              method:"post",
                data:data,
              success:function (r){
                  if(r.code===unprocesable_entity){
                      alert(r.message)
                  }
                  if(r.code===created){
                        alert(r.message);
                        console.log(r.data)
                        document.cookie = r.data
                        location.href="/index.html"
                  }
              }
          })
        }

    }





})