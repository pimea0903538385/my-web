let app=new Vue({
    el:'#registerapp',
    data:{
        username:'',
        nickname:'',
        userBirthday:'',
        gender:'',
        email:'',
        phone:'',
        password:'',
        confirm:'',
    },
    methods:{
            register:function (){
             let data={
                 username:this.username,
                 nickname: this.nickname,
                 userBirthday: this.userBirthday,
                 gender: this.gender,
                 email: this.email,
                 phone: this.phone,
                 password: this.password,
                 confirm: this.confirm
             }
             console.log(data)
                let _this=this ;
            $.ajax({
                url:"/register",
                method:'POST',
                data:data,
                success:function (r){
               if(r.code===created){
                  alert(r.message)
                 location.href='/login.html'
               }else{
                  alert(r.message);
                  location.href='/register.html'
               }
                }
            })

    }
    }
})
