let GetProductIDApp=new Vue({
    el:"#GetProductIDApp",
    methods:{
        getproductid:function (){
            let productid=location.search
            productid=productid.substring(1)
            console.log(productid)
            let data={
                jwt:document.cookie,
                id:productid,
            }
            console.log(data.jwt)
            $.ajax({
                url:"/addshoppingcart",
                method:"get",
                data:data,
                success:function (r){
                    if(r.code==ok){
                        alert(r.message)
                    }else{
                        alert("請先登入後再使用購物車功能!")
                        location.href="/login.html"
                    }
                }
            })

        }
    }

})
let commodityApp=new Vue({
    el:"#product",
    data: {
             product:[],
},
    methods:{
    getProductDetail:function(){
        let str={
            jwt:document.cookie
        }
        console.log(str.jwt)
         $.ajax({
               url:"/productdetail",
             method:"post",
             data:str,
             success:function (r){
              if(r.code==ok){
                  commodityApp.product=r.data

              }

             }
         })
    },checkShoppingcart:function (){

                   if(commodityApp.product.length==0) {
                       alert("你的購物車是空的!請選擇商品在結帳")
                       location.href = "index.html"
                   }else{
                       location.href="checkout.html"
                   }

        }
},created:function (){
        this.getProductDetail()

    },computed:{
         sum:function (){
            let total = 0;
            this.product.forEach(product => {
                total += product.productPrice * product.productAmount;
            });
            return total;
        },getuser:function (){
             let str=document.cookie
            return str;
        },getshoppingid:function (){


        }
    }
})









