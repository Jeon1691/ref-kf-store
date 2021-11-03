import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dave on 2017. 6. 14..
 */
public class PaypalTest {

    public static String clientID = "ASC5hHswi5FfhRl0xwEVu4rjLIZvRe8sC6TiO6iKOfQHckZVGzmjN_7mkokKPaGLIp9QfBvBoIrbB9XF";
    public static String clientSecret = "EDo7S1-PtbWZg_m7xum-dEcacK4zGIxQ_mHTGvEPGrh5Z_vmEP4PWt-k6ZeUCSkmdfLMo-wIE3yDSMWi";

    public static void main(String[] args) {
        try {
            // Authorization Code and Co-relationID retrieved from Mobile SDK.

            APIContext context = new APIContext(clientID, clientSecret, "sandbox");

//            // Fetch the long lived refresh token from authorization code.
//            String refreshToken = FuturePayment.fetchRefreshToken(context, authorizationCode);
//            // Store the refresh token in long term storage for future use.
//
//            // Set the refresh token to context to make future payments of
//            // pre-consented customer.
//            context.setRefreshToken(refreshToken);

            // Create Payment Object
            Payer payer = new Payer();
            payer.setPaymentMethod("paypal");
            Amount amount = new Amount();
            amount.setTotal("0.17");
            amount.setCurrency("USD");
            Transaction transaction = new Transaction();
            transaction.setAmount(amount);
            List<Transaction> transactions = new ArrayList<Transaction>();
            transactions.add(transaction);

            Payment payment = new Payment();
            payment.setIntent("sale");
            payment.setPayer(payer);
            payment.setTransactions(transactions);
            RedirectUrls redirectUrls = new RedirectUrls();
            redirectUrls.setCancelUrl("http://www.paypal.com/cancel");
            redirectUrls.setReturnUrl("http://www.paypal.com/return");
            payment.setRedirectUrls(redirectUrls);

            Payment createdPayment = payment.create(context);
            System.out.println(createdPayment.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(Payment.getLastRequest());
            System.out.println(Payment.getLastResponse());
        }
    }

}
