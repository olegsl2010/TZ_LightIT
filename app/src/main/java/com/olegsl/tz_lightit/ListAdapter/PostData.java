package com.olegsl.tz_lightit.ListAdapter;

public class PostData {

    private  Integer idProduct;

    private String postTitleProduct;

    private String postDescriptionProduct;

    private int postImageProduct;

    public void setPostImageProduct(int postImageProduct) {
        this.postImageProduct = postImageProduct;
    }

    public int getPostImageProduct() {

        return postImageProduct;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public void setPostTitleProduct(String postTitleProduct) {
        this.postTitleProduct = postTitleProduct;
    }

    public void setPostDescriptionProduct(String postDescriptionProduct) {
        this.postDescriptionProduct = postDescriptionProduct;
    }



    public String getPostTitleProduct() {
        return postTitleProduct;
    }

    public String getPostDescriptionProduct() {
        return postDescriptionProduct;
    }
}
