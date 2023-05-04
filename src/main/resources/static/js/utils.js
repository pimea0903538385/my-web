let ok=200;
let created=201;
let accepted=202;
let no_content=204;
let invalid_request=400;
let unauthorized=401;
let forbidden=403;
let not_found=404;
let gone=410;
let unprocesable_entity=422;
let internal_server_error=500;


function getcookies(){
    let data={
       str:document.cookie,
    }
       console.log(data)
   $.ajax({
       url:"/shoppingcart",
       method:"post",
       data:data,
       success:function (r){
           if(r.code==unprocesable_entity){
               alert(r.message);
               location.href="/login.html"
           }if(r.code==ok) {
               location.href="/shoppingcart.html"
           }
       }
   })

}



let categories=new Vue({
    el:"#categoriesapp",
    data:{
        categories:[],
    },
    methods:{
        loadcategoris:function () {

            $.ajax({
                url: "/categories",
                method: 'get',
                success: function (r) {
                    console.log(r);
                    if (r.code == ok) {
                        console.log(r.data)
                        categories.categories=r.data

                    }
                }
            })
        }},


    created:function (){
        this.loadcategoris();
    },

});
