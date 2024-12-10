package org.example.Services;

import java.util.HashMap;
import java.util.Map;

import io.qameta.allure.Allure;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.authentication.OAuth2Scheme;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * Classe responsavel por realizar as chamadas HTTPS utilizando o RestAssured
 */
public class GenericService {

    private RequestSpecBuilder requestSpecBuilder;
    private Map<String, Object> pathParams = new HashMap<>();
    private Map<String, Object> queryParams = new HashMap<>();
    private Map<String, Object> headers = new HashMap<>();
    private String rota = "";
    private Object body = "";

    public GenericService() {
        // TODO - Adicionar o filtro GENERICO QUE SALVA A REQUISIÇÃO E RESPOSTA Numa
        this.requestSpecBuilder = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured()
                        .setRequestAttachmentName("Requisição Realizada")
                        .setResponseAttachmentName("Resposta"))
                .setRelaxedHTTPSValidation();
    }

    // Urls
    public void setBaseUri(String baseUri) {
        this.requestSpecBuilder.setBaseUri(baseUri);
    }

    public void setBasePath(String basePath) {
        this.requestSpecBuilder.setBasePath(basePath);
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    // Headers
    public void addHeader(String key, Object value) {
        this.headers.put(key, value);
    }

    public void setHeader(String key, Object value) {
        this.headers.put(key, value);
    }

    public void removeHeader(String key) {
        this.headers.remove(key);
    }

    // Params
    public void addPathParam(String key, Object value) {
        this.pathParams.put(key, value);
    }

    public void setPathParam(String key, Object value) {
        this.pathParams.put(key, value);
    }

    public void removePathParam(String key) {
        this.pathParams.remove(key);
    }

    public void addQueryParams(String key, Object value) {
        this.queryParams.put(key, value);
    }

    public void setQueryParams(String key, Object value) {
        this.queryParams.put(key, value);
    }

    public void removeQueryParams(String key) {
        this.queryParams.remove(key);
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public void prepararParaNovaRequisicao() {
        if (!pathParams.isEmpty()) {
            this.pathParams.clear();
        }

        if (!queryParams.isEmpty()) {
            this.queryParams.clear();
        }

        if (!headers.isEmpty()) {
            this.headers.clear();
        }

        this.body = "";
        this.rota = "";
    }

    // Token
    public void setBasicAuth(String username, String password) {
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName(username);
        authScheme.setPassword(password);
        this.requestSpecBuilder.setAuth(authScheme);
    }

    public void setOAuth2Token(String token) {
        OAuth2Scheme authScheme = new OAuth2Scheme();
        authScheme.setAccessToken(token);
        this.requestSpecBuilder.setAuth(authScheme);
    }

    public void setApiKeyAuth(String apiKey) {
        this.requestSpecBuilder.addHeader("Authorization", "ApiKey " + apiKey);
    }

    public void setJwtAuth(String jwtToken) {
        this.requestSpecBuilder.addHeader("Authorization", "Bearer " + jwtToken);
    }

    private Response executeRequest(String method) {
        return Allure.step("Requisição " + method.toUpperCase() + " Realizada", () -> {
            return RestAssured
                    .given()
                    .spec(this.requestSpecBuilder.build())
                    .pathParams(this.pathParams)
                    .queryParams(this.queryParams)
                    .headers(this.headers)
                    .body(this.body)
                    .log().all()
                    .request(method, this.rota);
        });
    }

    public Response get() {
        return executeRequest("get");
    }

    public Response post() {
        return executeRequest("post");
    }

    public Response put() {
        return executeRequest("put");
    }

    public Response delete() {
        return executeRequest("delete");
    }

    public Response patch() {
        return executeRequest("patch");
    }
}