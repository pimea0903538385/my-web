
let product=new Vue({
    el:"#productapp",
    data:{
        product:[],
        pageInfo:[]
    },
    methods:{

        setcommodity:function (pageNum){
            if(!pageNum ){
                pageNum=1;
            }
            //console.log(pageNum)
            let categoryId=location.search;
            categoryId=categoryId.substring(1)
            //console.log("ID={}",categoryId);
            $.ajax({
                url:"/commodity/"+categoryId,
                method:"get",
                data:{
                  pagenum:pageNum
                },
                success:function (r){
                    //console.log(r.data)
                    product.product=r.data.list;
                    product.pageInfo=r.data;

                }
            })
        }

    },
    created:function (){
        this.setcommodity();
    }
});

let commodity=new Vue({
    el:"#commodity",
    data:{
        commodity:[],
    },
    methods:{
        setcommoditydetail:function (){
            let Id=location.search;
            Id=Id.substring(1)
            $.ajax({
                url:"/commodity/detail/"+Id,
                method:"get",
                success:function (r){
                    //console.log(r.data)
                    commodity.commodity=r.data;

                }
            })
        }

    },
    created:function (){
        this.setcommoditydetail();
    }
});











