package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import tn.esprit.spring.dto.CheckoutItemDto;

@Service
public class PaimentServiceImpl {


    @Value("${base_url}")
    private String baseURL;

    @Value("${Stripe.apiKey}")
    private String apiKey;
    
    public Session createSession(List<CheckoutItemDto> checkoutItemDtoList) throws StripeException {
    	
    	String success_url = baseURL + "payment/success";
    	String cancel_url = baseURL + "payment/failed";
    	
    	Stripe.apiKey = apiKey;
    	
        List<SessionCreateParams.LineItem> sessionItemList = new ArrayList<>();


        for (CheckoutItemDto checkoutItemDto: checkoutItemDtoList) {
            sessionItemList.add(this.createSessionLineItem(checkoutItemDto));
        }

        SessionCreateParams params = SessionCreateParams.builder()
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setCancelUrl(cancel_url)
                .addAllLineItem(sessionItemList)
                .setSuccessUrl(success_url)
                .build();
        return Session.create(params);

    }

    
    private SessionCreateParams.LineItem createSessionLineItem(CheckoutItemDto checkoutItemDto) {

        return SessionCreateParams.LineItem.builder()
                .setPriceData(this.createPriceData(checkoutItemDto))
                .setQuantity(Long.parseLong(String.valueOf(checkoutItemDto.getQuantity())))
                .build();

    }
    

    private SessionCreateParams.LineItem.PriceData createPriceData(CheckoutItemDto checkoutItemDto) {
        return SessionCreateParams.LineItem.PriceData.builder()
                .setCurrency("usd")
                .setUnitAmount((long)(checkoutItemDto.getPrice()*100))
                .setProductData(
                        SessionCreateParams.LineItem.PriceData.ProductData.builder()
                            .setName(checkoutItemDto.getProductName())
                            .build()
                ).build();
    }
    
}
