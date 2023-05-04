let UploadProduct=new Vue({
    el:"#uploadProduct",
    data:{
        productName: '',
        productDescription: '',
        productPrice: '',
        productAmount: '',
        productImages: [],
    },methods:{
        upload:function (){
           let files=document.querySelector('#formFileMultiple').files;
           let formData = new FormData();
            formData.append('ProductName', this.productName);
            formData.append('ProductDescription', this.productDescription);
            formData.append('ProductPrice', this.productPrice);
            formData.append('ProductAmount', this.productAmount);
            for (let i = 0; i < files.length; i++) {
                const file = files[i];
                const reader = new FileReader();
                reader.readAsDataURL(file);
                reader.onload = function () {
                    const base64String = reader.result.split(',')[1];
                    formData.append('ProductImages', base64String);
                };
            } $.ajax({
                url:"/UploadProduct",
                method:"post",
                data:formData,
                success:function (r){
                    alert(r.message)
                    location.href="/index.html"
                }

            })
        }
    },
})