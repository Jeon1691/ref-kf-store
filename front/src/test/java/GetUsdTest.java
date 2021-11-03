import net.sf.json.JSONObject;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Created by Dave on 2017. 5. 8..
 */
public class GetUsdTest {

    public static void main(String [] args){

        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder.newInstance().scheme("http").host("query.yahooapis.com")
                .path("/v1/public/yql")
                .queryParam("q", "select * from yahoo.finance.xchange where pair='USDKRW'")
                .queryParam("format", "json")
                .queryParam("diagnostics", true)
                .queryParam("env", "store://datatables.org/alltableswithkeys")
                .build().encode().toUri();

        String response = restTemplate.getForObject(uri, String.class);
        JSONObject jsonObject = JSONObject.fromObject(response);

        System.out.println(jsonObject.getJSONObject("query").getJSONObject("results").getJSONObject("rate").get("Rate"));
    }


}
