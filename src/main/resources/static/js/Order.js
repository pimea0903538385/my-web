let OrderApp=new Vue({
    el:"#orderapp",
    data:{
        order:{}
    },
    methods:{
        checkedOrder:function (){
             let username=document.cookie;
            if(username==null){
                alert("請先登入再查看訂單!")
                location.href="login.html"
            }else {
                $.ajax({
                    url:"/OrderCreated",
                    method:"post",
                    data:{
                        jwt:username
                    },
                    success:function (r){
                        OrderApp.order=r.data;
                    }
                })
            }
        }

    },created:function (){
        this.checkedOrder();
    },computed:function (){
        this.checkedOrder();
    }





})