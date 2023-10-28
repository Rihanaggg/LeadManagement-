package com.example.leadmanager;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.example.leadmanager.dto.FirstFormDTO;
import com.example.leadmanager.entity.Lead;
import com.example.leadmanager.entity.NewLead;
import com.example.leadmanager.repository.LeadRepository;
import com.example.leadmanager.repository.NewLeadRepository;
import com.example.leadmanager.service.LeadService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = LeadmanagerApplication.class)
public class LeadIntegrationTesting {
    
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private NewLeadRepository newLeadRepository;

    @Autowired
    private LeadService leadService;

    private static HttpHeaders headers;

    private final ObjectMapper objectMapper = new ObjectMapper();

    

//     @Test
   
//     public void testOrderById() throws JsonProcessingException {

//         HttpHeaders headers = new HttpHeaders();

//         headers.set("Authorization",

//                 "Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiUmloYW5hIiwiZXhwIjoxNjk4MDgzODExLCJpYXQiOjE2OTc5OTc0MTEsInNjb3BlIjoiUk9MRV9BRE1JTiJ9.l06UBOu9W8Hf9Mu0Qtj-DvAiduzIaZqYKiNiK9xc7zD--KgGVi_bdERcruUF1aNW2dq7M0bhlGEORTEe401wOclKbTBme8dTjbl6uzVD-u20E-6kxxogjBfqHfJ8lKlJnP2xBVdRv8qEaFOkdGJN5FxhdXMdO6QTyza3kldOSpjh4jTyq71DIv1nCPjJrlxSrvrFX0Xof3POB9AppBa6gB6dy-f-9EJDk4Mj3xjF6kLjFloaIv3MgPGpG--g6GIx-CtNkwsYZVC-E7KiJ3ASI97ezsBvTUc0kdaKZkfuhxqrgdKzEajVKotUVFoVE4P2S0z0A2EGpDB-WRK-OFNigQ");

//         NewLead newLead = new NewLead();
//         newLead.setName("Nidhi");
//         newLead.setEmail("valid@example.com");
//         newLead.setPhone("1234567890");
//         newLead.setCompanyName("Example Company");
//         newLead.setJobTitle("manager");
//         newLead.setAddress("123,street");
//         newLead.setState("london");
//         newLead.setRegion("east");
//         newLead.setWebsite("www.tt.com");
//         newLead.setTypeOfBusiness("sports");
//         newLead.setRequiredQuantity(400);
//         newLead.setExpectedRevenue(45900);
//         newLead.setProbability(0.80);
//         newLead.setProducts("cloud");
//         newLead.setStatus("new");
//         newLead.setSource("refferal");
//         newLead = newLeadRepository.save(newLead);

//         Lead lead = new Lead();
//         lead.setNewLead(newLead);
//         lead = leadRepository.save(lead);

//         HttpEntity<String> entity = new HttpEntity<>(null, headers);
//         // ResponseEntity<Lead> response = restTemplate.getForEntity(
//         //         createURLWithPort() + "/lead/" + 7,entity, Lead.class);
//                 String url = "http://localhost:" + port + "/api/leads/lead/7";
//                 ResponseEntity<Lead> response = restTemplate.getForEntity(url, Lead.class);

//         Lead leadRes = response.getBody();

//         String expected = "{" +
//         "\"leadId\": 7," +
//         "\"newLead\": {" +
//         "\"newleadid\": 7," +
//         "\"name\": \"Nidhi\"," +
//         "\"companyName\": \"Example Company\"," +
//         "\"email\": \"valid@example.com\"," +
//         "\"phone\": \"1234567890\"," +
//         "\"jobTitle\": \"manager\"," +
//         "\"address\": \"123,street\"," +
//         "\"state\": \"london\"," +
//         "\"region\": \"east\"," +
//         "\"website\": \"www.tt.com\"," +
//         "\"typeOfBusiness\": \"sports\"," +
//         "\"requiredQuantity\": 400," +
//         "\"expectedRevenue\": 45900," +
//         "\"probability\": 0.80," +
//         "\"products\": \"cloud\"," +
//         "\"status\": \"new\"," +
//         "\"source\": \"refferal\"" +
//         "}," +
//         "\"account\": null," +
//         "\"contact\": null," +
//         "\"opportunity\": null" +
//         "}";

//         // Check if response status is 200 OK
//        // assertEquals(response.getStatusCodeValue(), 200);

//        assertEquals(HttpStatus.OK, response.getStatusCode());

//         // Check if the returned lead matches the created lead
//         assertNotNull(leadRes);
//         assertEquals(lead.getLeadId(), leadRes.getLeadId());
//         assertEquals(newLead.getName(), leadRes.getNewLead().getName());

//         // HttpEntity<String> entity = new HttpEntity<>(null, headers);
//         // ResponseEntity<Order> response = restTemplate.exchange(
//         //         (createURLWithPort() + "/20"), HttpMethod.GET, entity, Order.class);
//         // Order orderRes = response.getBody();
//         // String expected = "{\"id\":20,\"buyer\":\"sam\",\"price\":50.0,\"qty\":4}";
//         // assertEquals(response.getStatusCodeValue(), 200);
//         // assertEquals(expected, objectMapper.writeValueAsString(orderRes));
//         // assert orderRes != null;
//         // assertEquals(orderRes, orderService.getOrderById(20L));
//         // assertEquals(orderRes.getBuyer(), orderService.getOrderById(20L).getBuyer());
//         // assertEquals(orderRes, orderRepository.findById(20L).orElse(null));
//     }

//     private String createURLWithPort() {
//         return "http://localhost:" + port + "/api/leads/lead"; // Adjust the URL according to your application's API structure
//     }
// }


@Test
void testCreateLeadpoint() throws Exception {

    FirstFormDTO firstFormDTO = new FirstFormDTO();
        firstFormDTO.setName("Nidhi");
        firstFormDTO.setEmail("valid@example.com");
        firstFormDTO.setPhone("1234567890");
        firstFormDTO.setCompanyName("Example Company");
        firstFormDTO.setJobTitle("manager");
        firstFormDTO.setAddress("123,street");
        firstFormDTO.setState("london");
        firstFormDTO.setRegion("east");
        firstFormDTO.setWebsite("www.tt.com");
        firstFormDTO.setTypeOfBusiness("sports");
        firstFormDTO.setRequiredQuantity(400);
        firstFormDTO.setExpectedRevenue(45900);
        firstFormDTO.setProbability(0.80);
        firstFormDTO.setProducts("cloud");
        firstFormDTO.setStatus("new");
        firstFormDTO.setSource("refferal");

    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiUmloYW5hIiwiZXhwIjoxNjk4NDc2OTMwLCJpYXQiOjE2OTgzOTA1MzAsInNjb3BlIjoiUk9MRV9VU0VSIn0.OHJ0kl4Cs1knYwvblQ4ay-5KBQqLnxFrPuO9NHc9UK30hd9YBdnLKTTghjHAXwwTSiuFY_u83VKPbJx10MCzLbeC2xbGepZaMVj41LCR4oBKZ3_lwBYGHUbWgF7AIOXcUNq22kl8SUO0fVLmHVpN-HLGwpuB_Y9y2LAo58ZmRKXcv2y9HXf41YnFDD91RlZurX7c0I4xjA1gDiZGHEY8DRAi0tJ-FsjL6ONGftDvH_FwpnoWtOp3ebxIH3sUlPQ2APvuKj2C-BnTmOb-lCvO185b_AlSP7kmDz5Ecr6KcWtjJfR1HZDbMFD098gj4eqG-HDRF2rp2mjuXx_ggpizUQ");
    headers.setContentType(MediaType.APPLICATION_JSON);
try {
    ResponseEntity<NewLead> response = restTemplate.exchange(
            "http://localhost:" + port + "/api/leads/create",
            HttpMethod.POST,
            new HttpEntity<>(firstFormDTO, headers),
            NewLead.class);

    NewLead createdLead = response.getBody();
    assertEquals(HttpStatus.CREATED, response.getStatusCode());

    // Add additional assertions as needed
} catch (Exception e) {
    e.printStackTrace();
}

}

@Test
void testUpdateLeadpoint() throws Exception {

    FirstFormDTO firstFormDTO = new FirstFormDTO();
        firstFormDTO.setName("Nitin");
        firstFormDTO.setEmail("value@example.com");
        firstFormDTO.setPhone("1234512345");
        firstFormDTO.setCompanyName("Company");
        firstFormDTO.setJobTitle("ceo");
        firstFormDTO.setAddress("123,street wall way");
        firstFormDTO.setState("paris");
        firstFormDTO.setRegion("west");
        firstFormDTO.setWebsite("www.tttt.com");
        firstFormDTO.setTypeOfBusiness("Tech");
        firstFormDTO.setRequiredQuantity(4000);
        firstFormDTO.setExpectedRevenue(4500);
        firstFormDTO.setProbability(0.85);
        firstFormDTO.setProducts("software");
        firstFormDTO.setStatus("qualified");
        firstFormDTO.setSource("web inquiry");

    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiUmloYW5hIiwiZXhwIjoxNjk4NDc2OTMwLCJpYXQiOjE2OTgzOTA1MzAsInNjb3BlIjoiUk9MRV9VU0VSIn0.OHJ0kl4Cs1knYwvblQ4ay-5KBQqLnxFrPuO9NHc9UK30hd9YBdnLKTTghjHAXwwTSiuFY_u83VKPbJx10MCzLbeC2xbGepZaMVj41LCR4oBKZ3_lwBYGHUbWgF7AIOXcUNq22kl8SUO0fVLmHVpN-HLGwpuB_Y9y2LAo58ZmRKXcv2y9HXf41YnFDD91RlZurX7c0I4xjA1gDiZGHEY8DRAi0tJ-FsjL6ONGftDvH_FwpnoWtOp3ebxIH3sUlPQ2APvuKj2C-BnTmOb-lCvO185b_AlSP7kmDz5Ecr6KcWtjJfR1HZDbMFD098gj4eqG-HDRF2rp2mjuXx_ggpizUQ");
    headers.setContentType(MediaType.APPLICATION_JSON);
try {
    ResponseEntity<NewLead> response = restTemplate.exchange(
            "http://localhost:" + port + "/api/leads/allupdate/3",
            HttpMethod.PUT,
            new HttpEntity<>(firstFormDTO, headers),
            NewLead.class);

    NewLead updatedLead = response.getBody();
    assertEquals(HttpStatus.OK, response.getStatusCode());

    // Add additional assertions as needed
} catch (Exception e) {
    e.printStackTrace();
}

}


@Test
void testAllLeads() throws Exception {

    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiUmloYW5hIiwiZXhwIjoxNjk4NDc2OTMwLCJpYXQiOjE2OTgzOTA1MzAsInNjb3BlIjoiUk9MRV9VU0VSIn0.OHJ0kl4Cs1knYwvblQ4ay-5KBQqLnxFrPuO9NHc9UK30hd9YBdnLKTTghjHAXwwTSiuFY_u83VKPbJx10MCzLbeC2xbGepZaMVj41LCR4oBKZ3_lwBYGHUbWgF7AIOXcUNq22kl8SUO0fVLmHVpN-HLGwpuB_Y9y2LAo58ZmRKXcv2y9HXf41YnFDD91RlZurX7c0I4xjA1gDiZGHEY8DRAi0tJ-FsjL6ONGftDvH_FwpnoWtOp3ebxIH3sUlPQ2APvuKj2C-BnTmOb-lCvO185b_AlSP7kmDz5Ecr6KcWtjJfR1HZDbMFD098gj4eqG-HDRF2rp2mjuXx_ggpizUQ");
    headers.setContentType(MediaType.APPLICATION_JSON);
try {
    ResponseEntity<Lead[]> response = restTemplate.exchange(

                "http://localhost:" + port + "/api/leads/all",

                HttpMethod.GET,

                new HttpEntity<>(headers),

                Lead[].class);
    

    Lead[] lead = response.getBody();
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(2, lead.length);
    // Add additional assertions as needed
} catch (Exception e) {
    e.printStackTrace();
}

}

@Test
void testLeadsById() throws Exception {

    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiUmloYW5hIiwiZXhwIjoxNjk4NDc2OTMwLCJpYXQiOjE2OTgzOTA1MzAsInNjb3BlIjoiUk9MRV9VU0VSIn0.OHJ0kl4Cs1knYwvblQ4ay-5KBQqLnxFrPuO9NHc9UK30hd9YBdnLKTTghjHAXwwTSiuFY_u83VKPbJx10MCzLbeC2xbGepZaMVj41LCR4oBKZ3_lwBYGHUbWgF7AIOXcUNq22kl8SUO0fVLmHVpN-HLGwpuB_Y9y2LAo58ZmRKXcv2y9HXf41YnFDD91RlZurX7c0I4xjA1gDiZGHEY8DRAi0tJ-FsjL6ONGftDvH_FwpnoWtOp3ebxIH3sUlPQ2APvuKj2C-BnTmOb-lCvO185b_AlSP7kmDz5Ecr6KcWtjJfR1HZDbMFD098gj4eqG-HDRF2rp2mjuXx_ggpizUQ");
    headers.setContentType(MediaType.APPLICATION_JSON);
try {
    ResponseEntity<Lead> response = restTemplate.exchange(

                "http://localhost:" + port + "/api/leads/lead/1",

                HttpMethod.GET,

                new HttpEntity<>(headers),

                Lead.class);
    

    Lead lead = response.getBody();
    assertEquals(HttpStatus.OK, response.getStatusCode());
    //assertEquals(2, lead.length);
    // Add additional assertions as needed
} catch (Exception e) {
    e.printStackTrace();
}

}

@Test
void testUpdateByAttributeLeadpoint() throws Exception {

    FirstFormDTO firstFormDTO = new FirstFormDTO();
       
        firstFormDTO.setWebsite("www.tteloco.com");
       

    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiUmloYW5hIiwiZXhwIjoxNjk4NDc2OTMwLCJpYXQiOjE2OTgzOTA1MzAsInNjb3BlIjoiUk9MRV9VU0VSIn0.OHJ0kl4Cs1knYwvblQ4ay-5KBQqLnxFrPuO9NHc9UK30hd9YBdnLKTTghjHAXwwTSiuFY_u83VKPbJx10MCzLbeC2xbGepZaMVj41LCR4oBKZ3_lwBYGHUbWgF7AIOXcUNq22kl8SUO0fVLmHVpN-HLGwpuB_Y9y2LAo58ZmRKXcv2y9HXf41YnFDD91RlZurX7c0I4xjA1gDiZGHEY8DRAi0tJ-FsjL6ONGftDvH_FwpnoWtOp3ebxIH3sUlPQ2APvuKj2C-BnTmOb-lCvO185b_AlSP7kmDz5Ecr6KcWtjJfR1HZDbMFD098gj4eqG-HDRF2rp2mjuXx_ggpizUQ");
    headers.setContentType(MediaType.APPLICATION_JSON);
try {
    ResponseEntity<NewLead> response = restTemplate.exchange(
            "http://localhost:" + port + "/api/leads/update/3",
            HttpMethod.PATCH,
            new HttpEntity<>(firstFormDTO, headers),
            NewLead.class);

    NewLead updatedLeadEntity = response.getBody();
    assertEquals(HttpStatus.OK, response.getStatusCode());

    // Add additional assertions as needed
} catch (Exception e) {
    e.printStackTrace();
}

}


@Test
void testDeleteLeadsById() throws Exception {

    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiUmloYW5hIiwiZXhwIjoxNjk4NDc2OTMwLCJpYXQiOjE2OTgzOTA1MzAsInNjb3BlIjoiUk9MRV9VU0VSIn0.OHJ0kl4Cs1knYwvblQ4ay-5KBQqLnxFrPuO9NHc9UK30hd9YBdnLKTTghjHAXwwTSiuFY_u83VKPbJx10MCzLbeC2xbGepZaMVj41LCR4oBKZ3_lwBYGHUbWgF7AIOXcUNq22kl8SUO0fVLmHVpN-HLGwpuB_Y9y2LAo58ZmRKXcv2y9HXf41YnFDD91RlZurX7c0I4xjA1gDiZGHEY8DRAi0tJ-FsjL6ONGftDvH_FwpnoWtOp3ebxIH3sUlPQ2APvuKj2C-BnTmOb-lCvO185b_AlSP7kmDz5Ecr6KcWtjJfR1HZDbMFD098gj4eqG-HDRF2rp2mjuXx_ggpizUQ");
    headers.setContentType(MediaType.APPLICATION_JSON);
try {
    ResponseEntity<Lead> response = restTemplate.exchange(

                "http://localhost:" + port + "/api/leads/delete/1",

                HttpMethod.GET,

                new HttpEntity<>(headers),

                Lead.class);
    

    Lead lead = response.getBody();
    assertEquals(HttpStatus.OK, response.getStatusCode());
    //assertEquals(2, lead.length);
    // Add additional assertions as needed
} catch (Exception e) {
    e.printStackTrace();
}

}
}
