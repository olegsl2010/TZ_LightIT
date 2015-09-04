package com.olegsl.tz_lightit.Instances;

/**
 * Created by apple on 03.09.15.
 */
public class Reviews {

    private Integer idReview;
    private Integer rateReview;
    private String textReview;
    private Integer idUser;
    private Integer idProduct;

    public Integer getIdReview() {
        return idReview;
    }

    public void setIdReview(Integer idReview) {
        this.idReview = idReview;
    }

    public Integer getRateReview() {
        return rateReview;
    }

    public void setRateReview(int rateReview) {
        this.rateReview = rateReview;
    }

    public String getTextReview() {
        return textReview;
    }

    public void setTextReview(String textRate) {
        this.textReview = textRate;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }
}
