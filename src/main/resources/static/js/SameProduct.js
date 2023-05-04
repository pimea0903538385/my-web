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
                url:"/commodity/"+0,
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

    let app = new Vue({
    el: '#app',
    data:{
        chooseproduct:[] ,//選中的商品

    },
    methods: {
    putincar:function() {
        this.chooseproduct.push(commodity.commodity);
        localStorage.setItem("chooseproduct", JSON.stringify(this.chooseproduct));
        alert("商品已經成功加入購物車")
    },
        add:function (index){
            let chooseproduct = JSON.parse(localStorage.getItem('chooseproduct')) || [];
            chooseproduct[index][0].commodityType++
            this.chooseproduct = chooseproduct
            localStorage.setItem("chooseproduct", JSON.stringify(this.chooseproduct))

        }
        ,noAdd:function (index){
              let chooseproduct = JSON.parse(localStorage.getItem('chooseproduct')) || [];
              if(chooseproduct[index][0].commodityType>1) {
                  chooseproduct[index][0].commodityType--
                  this.chooseproduct = chooseproduct
                  localStorage.setItem("chooseproduct", JSON.stringify(this.chooseproduct))
              }
        },deleteProduct:function (index){
            let chooseproduct = JSON.parse(localStorage.getItem('chooseproduct')) || []
            if(chooseproduct!=null){
                chooseproduct.splice(index,1)
                this.chooseproduct = chooseproduct
                localStorage.setItem("chooseproduct", JSON.stringify(this.chooseproduct))
            }
        }

},
    mounted:function(){
    //每個頁面啟動時取最新的購物車資訊
        this.chooseproduct = JSON.parse(localStorage.getItem("chooseproduct")) || [];
    },computed: {
            totalPrice() {
                let totalprice = 0;
                for (let i = 0; i < this.chooseproduct.length; i++) {
                    totalprice = this.chooseproduct[i][0].commodityType * this.chooseproduct[i][0].commodityPrice
                }
                return totalprice
            }, getuser: function () {
                let str = document.cookie
                return str;
            }, Getproduct: function () {
                let product = [];
                for (let i = 0; i < this.chooseproduct.length; i++) {
                    let currentProduct = this.chooseproduct[i][0].commodityId;
                    product.push(currentProduct);

                }
                return product
            }, GetproductAmount: function () {
                let productAmount = [];
                for (let i = 0; i < this.chooseproduct.length; i++) {
                    let currentProduct = this.chooseproduct[i][0].commodityType;
                    productAmount.push(currentProduct);
                    localStorage.clear();
                }
                return productAmount
            }, GetproductPrice: function () {
                let productPrice = [];
                for (let i = 0; i < this.chooseproduct.length; i++) {
                    let currentProduct = this.chooseproduct[i][0].commodityPrice;
                    productPrice.push(currentProduct);
                    localStorage.clear();
                }
                return productPrice
            }
        }
    })
