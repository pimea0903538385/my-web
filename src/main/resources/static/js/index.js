let Newporduct=new Vue({
    el:"#newproduct",
    data:{
        product:[]
    },
    methods:{
        setnewproduct:function (pageNum){
            if(!pageNum ){
                pageNum=1;
            }
            $.ajax({
                url:"/commodity/"+1,
                method:"get",
                data:{
                    pagenum:pageNum
                },
                success:function (r){
                    Newporduct.product=r.data.list;

                }
            })
        }

    },created:function (){
        this.setnewproduct();
    }

});