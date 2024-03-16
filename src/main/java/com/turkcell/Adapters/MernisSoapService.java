package com.turkcell.Adapters;

import com.turkcell.Abstract.ICustomerCheckService;
import com.turkcell.entities.Customer;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class MernisSoapService implements ICustomerCheckService {

    @Override
    public boolean checkIfRealPerson(Customer customer) {
        String endpoint = "http://tckimlik.nvi.gov.tr/service/kpspublic.asmx";
        String soapAction = "http://tckimlik.nvi.gov.tr/WS/TCKimlikNoDogrula";
        String soapRequest = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
                "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " +
                "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">" +
                "<soap:Body>" +
                "<TCKimlikNoDogrula xmlns=\"http://tckimlik.nvi.gov.tr/WS\">" +
                "<TCKimlikNo>"+ customer.getNationalityId() +"</TCKimlikNo>" +
                "<Ad>" + customer.getName() +"</Ad>" +
                "<Soyad> "+ customer.getSurname() +"</Soyad>" +
                "<DogumYili>"+ customer.getDateOfBirth() +"</DogumYili>" +
                "</TCKimlikNoDogrula>" +
                "</soap:Body>" +
                "</soap:Envelope>";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(endpoint);
            httpPost.setHeader("Content-Type", "application/soap+xml; charset=utf-8");
            httpPost.setHeader("SOAPAction", soapAction);

            StringEntity entity = new StringEntity(soapRequest);
            httpPost.setEntity(entity);

            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();

            if (responseEntity != null) {
                String responseString = EntityUtils.toString(responseEntity);
                System.out.println("Response: " + responseString);
            } else {
                System.out.println("Response is empty");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

}
