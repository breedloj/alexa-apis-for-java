/*
* Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
* except in compliance with the License. A copy of the License is located at
*
* http://aws.amazon.com/apache2.0/
*
* or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
* the specific language governing permissions and limitations under the License.
*/

package com.amazon.ask.model.services.skillManagement;

import com.amazon.ask.model.services.*;
import com.amazon.ask.model.services.*;
import com.amazon.ask.model.services.lwa.*;
import com.amazon.ask.model.services.lwa.model.GrantType;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;



public class SkillManagementServiceClient extends BaseServiceClient implements SkillManagementService {

  private final LwaClient lwaClient;

  public SkillManagementServiceClient(ApiConfiguration apiConfiguration, AuthenticationConfiguration authenticationConfiguration) {
      super(apiConfiguration);
      this.lwaClient = LwaClient.builder()
          .withAuthenticationConfiguration(authenticationConfiguration)
          .withGrantType(GrantType.REFRESH_TOKEN)
          .withApiConfiguration(DefaultApiConfiguration.builder()
                                    .withApiClient(apiConfiguration.getApiClient())
                                    .withSerializer(apiConfiguration.getSerializer())
                                    .build())
          .build();
  }

  public SkillManagementServiceClient(ApiConfiguration apiConfiguration, LwaClient lwaClient) {
      super(apiConfiguration);
      this.lwaClient = lwaClient;
  }

  /**
   * Create new upload
   * Create a new upload for a catalog and returns location to track the upload process.
   * @param catalogId Unique identifier of the catalog (required)
   * @param catalogUploadRequestBody Request body for create content upload (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callCreateCatalogUploadV1(String catalogId, com.amazon.ask.smapi.model.v1.catalog.upload.CatalogUploadBase catalogUploadRequestBody) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("catalogId", catalogId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/catalogs/{catalogId}/uploads";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 202, "Accepted"));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 503, "Service Unavailable."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, catalogUploadRequestBody, null, false);
  }

  /**
   * Create new upload
   * Create a new upload for a catalog and returns location to track the upload process.
   * @param catalogId Unique identifier of the catalog (required)
   * @param catalogUploadRequestBody Request body for create content upload (required)
   * @throws ServiceException if fails to make API call
   */
  public void createCatalogUploadV1(String catalogId, com.amazon.ask.smapi.model.v1.catalog.upload.CatalogUploadBase catalogUploadRequestBody) throws ServiceException {
    this.callCreateCatalogUploadV1(catalogId, catalogUploadRequestBody).getResponse();
  }

  /**
   * Get upload
   * Gets detailed information about an upload which was created for a specific catalog. Includes the upload&#39;s ingestion steps and a url for downloading the file.
   * @param catalogId Unique identifier of the catalog (required)
   * @param uploadId Unique identifier of the upload (required)
   * @return com.amazon.ask.smapi.model.v1.catalog.upload.GetContentUploadResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.catalog.upload.GetContentUploadResponse> callGetContentUploadByIdV1(String catalogId, String uploadId) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("catalogId", catalogId);
    pathParams.put("uploadId", uploadId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/catalogs/{catalogId}/uploads/{uploadId}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.catalog.upload.GetContentUploadResponse.class, 200, "successful operation"));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.catalog.upload.GetContentUploadResponse.class, false);
  }

  /**
   * Get upload
   * Gets detailed information about an upload which was created for a specific catalog. Includes the upload&#39;s ingestion steps and a url for downloading the file.
   * @param catalogId Unique identifier of the catalog (required)
   * @param uploadId Unique identifier of the upload (required)
   * @return com.amazon.ask.smapi.model.v1.catalog.upload.GetContentUploadResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.catalog.upload.GetContentUploadResponse getContentUploadByIdV1(String catalogId, String uploadId) throws ServiceException {
    return this.callGetContentUploadByIdV1(catalogId, uploadId).getResponse();
  }

  /**
   * 
   * Generate preSigned urls to upload data
   * @param catalogId Unique identifier of the catalog (required)
   * @param generateCatalogUploadUrlRequestBody Request body to generate catalog upload url (required)
   * @return com.amazon.ask.smapi.model.v1.catalog.CreateContentUploadUrlResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.catalog.CreateContentUploadUrlResponse> callGenerateCatalogUploadUrlV1(String catalogId, com.amazon.ask.smapi.model.v1.catalog.CreateContentUploadUrlRequest generateCatalogUploadUrlRequestBody) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("catalogId", catalogId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/catalogs/{catalogId}/urls";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.catalog.CreateContentUploadUrlResponse.class, 201, "Successful operation."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 503, "Service Unavailable."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, generateCatalogUploadUrlRequestBody, com.amazon.ask.smapi.model.v1.catalog.CreateContentUploadUrlResponse.class, false);
  }

  /**
   * 
   * Generate preSigned urls to upload data
   * @param catalogId Unique identifier of the catalog (required)
   * @param generateCatalogUploadUrlRequestBody Request body to generate catalog upload url (required)
   * @return com.amazon.ask.smapi.model.v1.catalog.CreateContentUploadUrlResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.catalog.CreateContentUploadUrlResponse generateCatalogUploadUrlV1(String catalogId, com.amazon.ask.smapi.model.v1.catalog.CreateContentUploadUrlRequest generateCatalogUploadUrlRequestBody) throws ServiceException {
    return this.callGenerateCatalogUploadUrlV1(catalogId, generateCatalogUploadUrlRequestBody).getResponse();
  }

  /**
   * 
   * Get the list of in-skill products for the vendor.
   * @param vendorId The vendor ID. (required)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @param productId The list of in-skill product IDs that you wish to get the summary for. A maximum of 50 in-skill product IDs can be specified in a single listInSkillProducts call. Please note that this parameter must not be used with &#39;nextToken&#39; and/or &#39;maxResults&#39; parameter. (optional)
   * @param stage Filter in-skill products by specified stage. (optional)
   * @param type Type of in-skill product to filter on. (optional)
   * @param referenceName Filter in-skill products by reference name. (optional)
   * @param status Status of in-skill product. (optional)
   * @param isAssociatedWithSkill Filter in-skill products by whether or not they are associated to a skill. (optional)
   * @return com.amazon.ask.smapi.model.v1.isp.ListInSkillProductResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.isp.ListInSkillProductResponse> callGetIspListForVendorV1(String vendorId, String nextToken, BigDecimal maxResults, List<String> productId, String stage, String type, String referenceName, String status, String isAssociatedWithSkill) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();

    if(vendorId != null) {
    queryParams.add(new Pair<String, String>("vendorId", vendorId));
  }

    if(nextToken != null) {
    queryParams.add(new Pair<String, String>("nextToken", nextToken));
  }

    if(maxResults != null) {
    queryParams.add(new Pair<String, String>("maxResults", maxResults.toString()));
  }

    if(productId != null) {
    for (Object param : productId) {
      queryParams.add(new Pair<String, String>("productId", param.toString()));
    }
  }

    if(stage != null) {
    queryParams.add(new Pair<String, String>("stage", stage));
  }

    if(type != null) {
    queryParams.add(new Pair<String, String>("type", type));
  }

    if(referenceName != null) {
    queryParams.add(new Pair<String, String>("referenceName", referenceName));
  }

    if(status != null) {
    queryParams.add(new Pair<String, String>("status", status));
  }

    if(isAssociatedWithSkill != null) {
    queryParams.add(new Pair<String, String>("isAssociatedWithSkill", isAssociatedWithSkill));
  }
    Map<String, String> pathParams = new HashMap<String, String>();
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/inSkillProducts";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.isp.ListInSkillProductResponse.class, 200, "Response contains list of in-skill products for the specified vendor and stage."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Bad request. Returned when a required parameter is not present, badly formatted. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Too many requests received."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error"));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.isp.ListInSkillProductResponse.class, false);
  }

  /**
   * 
   * Get the list of in-skill products for the vendor.
   * @param vendorId The vendor ID. (required)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @param productId The list of in-skill product IDs that you wish to get the summary for. A maximum of 50 in-skill product IDs can be specified in a single listInSkillProducts call. Please note that this parameter must not be used with &#39;nextToken&#39; and/or &#39;maxResults&#39; parameter. (optional)
   * @param stage Filter in-skill products by specified stage. (optional)
   * @param type Type of in-skill product to filter on. (optional)
   * @param referenceName Filter in-skill products by reference name. (optional)
   * @param status Status of in-skill product. (optional)
   * @param isAssociatedWithSkill Filter in-skill products by whether or not they are associated to a skill. (optional)
   * @return com.amazon.ask.smapi.model.v1.isp.ListInSkillProductResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.isp.ListInSkillProductResponse getIspListForVendorV1(String vendorId, String nextToken, BigDecimal maxResults, List<String> productId, String stage, String type, String referenceName, String status, String isAssociatedWithSkill) throws ServiceException {
    return this.callGetIspListForVendorV1(vendorId, nextToken, maxResults, productId, stage, type, referenceName, status, isAssociatedWithSkill).getResponse();
  }

  /**
   * 
   * Creates a new in-skill product for given vendorId.
   * @param createInSkillProductRequest defines the request body for createInSkillProduct API. (required)
   * @return com.amazon.ask.smapi.model.v1.isp.ProductResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.isp.ProductResponse> callCreateIspForVendorV1(com.amazon.ask.smapi.model.v1.isp.CreateInSkillProductRequest createInSkillProductRequest) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/inSkillProducts";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.isp.ProductResponse.class, 201, "Success."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Bad request. Returned when a required parameter is not present, badly formatted. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Too many requests received."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error"));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, createInSkillProductRequest, com.amazon.ask.smapi.model.v1.isp.ProductResponse.class, false);
  }

  /**
   * 
   * Creates a new in-skill product for given vendorId.
   * @param createInSkillProductRequest defines the request body for createInSkillProduct API. (required)
   * @return com.amazon.ask.smapi.model.v1.isp.ProductResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.isp.ProductResponse createIspForVendorV1(com.amazon.ask.smapi.model.v1.isp.CreateInSkillProductRequest createInSkillProductRequest) throws ServiceException {
    return this.callCreateIspForVendorV1(createInSkillProductRequest).getResponse();
  }

  /**
   * 
   * Disassociates an in-skill product from a skill.
   * @param productId The in-skill product ID. (required)
   * @param skillId The skill ID. (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callDisassociateIspWithSkillV1(String productId, String skillId) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("productId", productId);
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/inSkillProducts/{productId}/skills/{skillId}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "Success. No content."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Bad request. Returned when a required parameter is not present, badly formatted. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "Request is forbidden."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "Requested resource not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Too many requests received."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error"));

    return this.executeRequest("DELETE", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, null, false);
  }

  /**
   * 
   * Disassociates an in-skill product from a skill.
   * @param productId The in-skill product ID. (required)
   * @param skillId The skill ID. (required)
   * @throws ServiceException if fails to make API call
   */
  public void disassociateIspWithSkillV1(String productId, String skillId) throws ServiceException {
    this.callDisassociateIspWithSkillV1(productId, skillId).getResponse();
  }

  /**
   * 
   * Associates an in-skill product with a skill.
   * @param productId The in-skill product ID. (required)
   * @param skillId The skill ID. (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callAssociateIspWithSkillV1(String productId, String skillId) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("productId", productId);
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/inSkillProducts/{productId}/skills/{skillId}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "Success. No content."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Bad request. Returned when a required parameter is not present, badly formatted. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "Request is forbidden."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "Requested resource not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Too many requests received."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error"));

    return this.executeRequest("PUT", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, null, false);
  }

  /**
   * 
   * Associates an in-skill product with a skill.
   * @param productId The in-skill product ID. (required)
   * @param skillId The skill ID. (required)
   * @throws ServiceException if fails to make API call
   */
  public void associateIspWithSkillV1(String productId, String skillId) throws ServiceException {
    this.callAssociateIspWithSkillV1(productId, skillId).getResponse();
  }

  /**
   * 
   * Deletes the in-skill product for given productId. Only development stage supported. Live in-skill products or in-skill products associated with a skill cannot be deleted by this API.
   * @param productId The in-skill product ID. (required)
   * @param stage Stage for skill. (required)
   * @param ifMatch Request header that specified an entity tag. The server will update the resource only if the eTag matches with the resource&#39;s current eTag. (optional)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callDeleteIspForProductV1(String productId, String stage, String ifMatch) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("productId", productId);
    pathParams.put("stage", stage);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    if (ifMatch != null) {
      headerParams.add(new Pair<String, String>("If-Match", ifMatch));
    }

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/inSkillProducts/{productId}/stages/{stage}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "Success. No content."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Bad request. Returned when a required parameter is not present, badly formatted. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "Request is forbidden."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "Requested resource not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 412, "Precondition failed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Too many requests received."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error"));

    return this.executeRequest("DELETE", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, null, false);
  }

  /**
   * 
   * Deletes the in-skill product for given productId. Only development stage supported. Live in-skill products or in-skill products associated with a skill cannot be deleted by this API.
   * @param productId The in-skill product ID. (required)
   * @param stage Stage for skill. (required)
   * @param ifMatch Request header that specified an entity tag. The server will update the resource only if the eTag matches with the resource&#39;s current eTag. (optional)
   * @throws ServiceException if fails to make API call
   */
  public void deleteIspForProductV1(String productId, String stage, String ifMatch) throws ServiceException {
    this.callDeleteIspForProductV1(productId, stage, ifMatch).getResponse();
  }

  /**
   * 
   * Resets the entitlement(s) of the Product for the current user.
   * @param productId The in-skill product ID. (required)
   * @param stage Stage for skill. (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callResetEntitlementForProductV1(String productId, String stage) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("productId", productId);
    pathParams.put("stage", stage);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/inSkillProducts/{productId}/stages/{stage}/entitlement";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "Success. No content."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Bad request. Returned when a required parameter is not present, badly formatted. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "Request is forbidden."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "Requested resource not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 412, "Precondition failed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Too many requests received."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error"));

    return this.executeRequest("DELETE", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, null, false);
  }

  /**
   * 
   * Resets the entitlement(s) of the Product for the current user.
   * @param productId The in-skill product ID. (required)
   * @param stage Stage for skill. (required)
   * @throws ServiceException if fails to make API call
   */
  public void resetEntitlementForProductV1(String productId, String stage) throws ServiceException {
    this.callResetEntitlementForProductV1(productId, stage).getResponse();
  }

  /**
   * 
   * Returns the in-skill product definition for given productId.
   * @param productId The in-skill product ID. (required)
   * @param stage Stage for skill. (required)
   * @return com.amazon.ask.smapi.model.v1.isp.InSkillProductDefinitionResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.isp.InSkillProductDefinitionResponse> callGetIspDefinitionV1(String productId, String stage) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("productId", productId);
    pathParams.put("stage", stage);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/inSkillProducts/{productId}/stages/{stage}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.isp.InSkillProductDefinitionResponse.class, 200, "Response contains the latest version of an in-skill product for the specified stage."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Bad request. Returned when a required parameter is not present, badly formatted. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "Requested resource not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Too many requests received."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error"));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.isp.InSkillProductDefinitionResponse.class, false);
  }

  /**
   * 
   * Returns the in-skill product definition for given productId.
   * @param productId The in-skill product ID. (required)
   * @param stage Stage for skill. (required)
   * @return com.amazon.ask.smapi.model.v1.isp.InSkillProductDefinitionResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.isp.InSkillProductDefinitionResponse getIspDefinitionV1(String productId, String stage) throws ServiceException {
    return this.callGetIspDefinitionV1(productId, stage).getResponse();
  }

  /**
   * 
   * Updates in-skill product definition for given productId. Only development stage supported.
   * @param productId The in-skill product ID. (required)
   * @param stage Stage for skill. (required)
   * @param updateInSkillProductRequest defines the request body for updateInSkillProduct API. (required)
   * @param ifMatch Request header that specified an entity tag. The server will update the resource only if the eTag matches with the resource&#39;s current eTag. (optional)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callUpdateIspForProductV1(String productId, String stage, com.amazon.ask.smapi.model.v1.isp.UpdateInSkillProductRequest updateInSkillProductRequest, String ifMatch) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("productId", productId);
    pathParams.put("stage", stage);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    if (ifMatch != null) {
      headerParams.add(new Pair<String, String>("If-Match", ifMatch));
    }

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/inSkillProducts/{productId}/stages/{stage}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "Success."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Bad request. Returned when a required parameter is not present, badly formatted. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "Request is forbidden."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "Requested resource not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 412, "Precondition failed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Too many requests received."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error"));

    return this.executeRequest("PUT", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, updateInSkillProductRequest, null, false);
  }

  /**
   * 
   * Updates in-skill product definition for given productId. Only development stage supported.
   * @param productId The in-skill product ID. (required)
   * @param stage Stage for skill. (required)
   * @param updateInSkillProductRequest defines the request body for updateInSkillProduct API. (required)
   * @param ifMatch Request header that specified an entity tag. The server will update the resource only if the eTag matches with the resource&#39;s current eTag. (optional)
   * @throws ServiceException if fails to make API call
   */
  public void updateIspForProductV1(String productId, String stage, com.amazon.ask.smapi.model.v1.isp.UpdateInSkillProductRequest updateInSkillProductRequest, String ifMatch) throws ServiceException {
    this.callUpdateIspForProductV1(productId, stage, updateInSkillProductRequest, ifMatch).getResponse();
  }

  /**
   * 
   * Get the associated skills for the in-skill product.
   * @param productId The in-skill product ID. (required)
   * @param stage Stage for skill. (required)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @return com.amazon.ask.smapi.model.v1.isp.AssociatedSkillResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.isp.AssociatedSkillResponse> callGetIspAssociatedSkillsV1(String productId, String stage, String nextToken, BigDecimal maxResults) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();

    if(nextToken != null) {
    queryParams.add(new Pair<String, String>("nextToken", nextToken));
  }

    if(maxResults != null) {
    queryParams.add(new Pair<String, String>("maxResults", maxResults.toString()));
  }
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("productId", productId);
    pathParams.put("stage", stage);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/inSkillProducts/{productId}/stages/{stage}/skills";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.isp.AssociatedSkillResponse.class, 200, "Returns skills associated with the in-skill product."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "Requested resource not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Too many requests received."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error"));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.isp.AssociatedSkillResponse.class, false);
  }

  /**
   * 
   * Get the associated skills for the in-skill product.
   * @param productId The in-skill product ID. (required)
   * @param stage Stage for skill. (required)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @return com.amazon.ask.smapi.model.v1.isp.AssociatedSkillResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.isp.AssociatedSkillResponse getIspAssociatedSkillsV1(String productId, String stage, String nextToken, BigDecimal maxResults) throws ServiceException {
    return this.callGetIspAssociatedSkillsV1(productId, stage, nextToken, maxResults).getResponse();
  }

  /**
   * 
   * Get the summary information for an in-skill product.
   * @param productId The in-skill product ID. (required)
   * @param stage Stage for skill. (required)
   * @return com.amazon.ask.smapi.model.v1.isp.InSkillProductSummaryResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.isp.InSkillProductSummaryResponse> callGetIspSummaryV1(String productId, String stage) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("productId", productId);
    pathParams.put("stage", stage);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/inSkillProducts/{productId}/stages/{stage}/summary";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.isp.InSkillProductSummaryResponse.class, 200, "Returns current in-skill product summary for productId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "Requested resource not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Too many requests received."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error"));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.isp.InSkillProductSummaryResponse.class, false);
  }

  /**
   * 
   * Get the summary information for an in-skill product.
   * @param productId The in-skill product ID. (required)
   * @param stage Stage for skill. (required)
   * @return com.amazon.ask.smapi.model.v1.isp.InSkillProductSummaryResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.isp.InSkillProductSummaryResponse getIspSummaryV1(String productId, String stage) throws ServiceException {
    return this.callGetIspSummaryV1(productId, stage).getResponse();
  }

  /**
   * 
   * Delete the catalog. 
   * @param catalogId Unique identifier of the catalog (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callDeleteInteractionModelCatalogV1(String catalogId) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("catalogId", catalogId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/api/custom/interactionModel/catalogs/{catalogId}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "No content; just confirm the catalog is deleted."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "The catalog cannot be deleted from reasons due to in-use by other entities."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "There is no catalog defined for the catalogId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("DELETE", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, null, false);
  }

  /**
   * 
   * Delete the catalog. 
   * @param catalogId Unique identifier of the catalog (required)
   * @throws ServiceException if fails to make API call
   */
  public void deleteInteractionModelCatalogV1(String catalogId) throws ServiceException {
    this.callDeleteInteractionModelCatalogV1(catalogId).getResponse();
  }

  /**
   * 
   * get the catalog definition 
   * @param catalogId Unique identifier of the catalog (required)
   * @return com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.CatalogDefinitionOutput
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.CatalogDefinitionOutput> callGetInteractionModelCatalogDefinitionV1(String catalogId) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("catalogId", catalogId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/api/custom/interactionModel/catalogs/{catalogId}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.CatalogDefinitionOutput.class, 200, "the catalog definition"));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "The catalog cannot be retrieved due to errors listed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "There is no catalog defined for the catalogId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.CatalogDefinitionOutput.class, false);
  }

  /**
   * 
   * get the catalog definition 
   * @param catalogId Unique identifier of the catalog (required)
   * @return com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.CatalogDefinitionOutput
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.CatalogDefinitionOutput getInteractionModelCatalogDefinitionV1(String catalogId) throws ServiceException {
    return this.callGetInteractionModelCatalogDefinitionV1(catalogId).getResponse();
  }

  /**
   * 
   * update description and vendorGuidance string for certain version of a catalog. 
   * @param catalogId Unique identifier of the catalog (required)
   * @param updateRequest  (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callUpdateInteractionModelCatalogV1(String catalogId, com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.UpdateRequest updateRequest) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("catalogId", catalogId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/api/custom/interactionModel/catalogs/{catalogId}/update";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "No content, indicates the fields were successfully updated."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "There is no catalog defined for the catalogId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, updateRequest, null, false);
  }

  /**
   * 
   * update description and vendorGuidance string for certain version of a catalog. 
   * @param catalogId Unique identifier of the catalog (required)
   * @param updateRequest  (required)
   * @throws ServiceException if fails to make API call
   */
  public void updateInteractionModelCatalogV1(String catalogId, com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.UpdateRequest updateRequest) throws ServiceException {
    this.callUpdateInteractionModelCatalogV1(catalogId, updateRequest).getResponse();
  }

  /**
   * 
   * Get the status of catalog resource and its sub-resources for a given catalogId. 
   * @param catalogId Unique identifier of the catalog (required)
   * @param updateRequestId The identifier for catalog version creation process (required)
   * @return com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.CatalogStatus
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.CatalogStatus> callGetInteractionModelCatalogUpdateStatusV1(String catalogId, String updateRequestId) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("catalogId", catalogId);
    pathParams.put("updateRequestId", updateRequestId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/api/custom/interactionModel/catalogs/{catalogId}/updateRequest/{updateRequestId}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.CatalogStatus.class, 200, "Returns the build status and error codes for the given catalogId"));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "There is no catalog defined for the catalogId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.CatalogStatus.class, false);
  }

  /**
   * 
   * Get the status of catalog resource and its sub-resources for a given catalogId. 
   * @param catalogId Unique identifier of the catalog (required)
   * @param updateRequestId The identifier for catalog version creation process (required)
   * @return com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.CatalogStatus
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.CatalogStatus getInteractionModelCatalogUpdateStatusV1(String catalogId, String updateRequestId) throws ServiceException {
    return this.callGetInteractionModelCatalogUpdateStatusV1(catalogId, updateRequestId).getResponse();
  }

  /**
   * 
   * Create a new version of catalog entity for the given catalogId. 
   * @param catalogId Unique identifier of the catalog (required)
   * @param catalog  (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callCreateInteractionModelCatalogVersionV1(String catalogId, com.amazon.ask.smapi.model.v1.skill.interactionModel.version.VersionData catalog) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("catalogId", catalogId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/api/custom/interactionModel/catalogs/{catalogId}/versions";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 202, "Returns update status location link on success."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error e.g. the catalog definition is invalid."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The specified catalog does not exist."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, catalog, null, false);
  }

  /**
   * 
   * Create a new version of catalog entity for the given catalogId. 
   * @param catalogId Unique identifier of the catalog (required)
   * @param catalog  (required)
   * @throws ServiceException if fails to make API call
   */
  public void createInteractionModelCatalogVersionV1(String catalogId, com.amazon.ask.smapi.model.v1.skill.interactionModel.version.VersionData catalog) throws ServiceException {
    this.callCreateInteractionModelCatalogVersionV1(catalogId, catalog).getResponse();
  }

  /**
   * 
   * Delete catalog version. 
   * @param catalogId Unique identifier of the catalog (required)
   * @param version Version for interaction model. (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callDeleteInteractionModelCatalogVersionV1(String catalogId, String version) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("catalogId", catalogId);
    pathParams.put("version", version);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/api/custom/interactionModel/catalogs/{catalogId}/versions/{version}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "No Content; Confirms that version is successfully deleted."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "There is no catalog version for this catalogId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("DELETE", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, null, false);
  }

  /**
   * 
   * Delete catalog version. 
   * @param catalogId Unique identifier of the catalog (required)
   * @param version Version for interaction model. (required)
   * @throws ServiceException if fails to make API call
   */
  public void deleteInteractionModelCatalogVersionV1(String catalogId, String version) throws ServiceException {
    this.callDeleteInteractionModelCatalogVersionV1(catalogId, version).getResponse();
  }

  /**
   * 
   * Get catalog version data of given catalog version. 
   * @param catalogId Unique identifier of the catalog (required)
   * @param version Version for interaction model. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.interactionModel.version.CatalogVersionData
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.interactionModel.version.CatalogVersionData> callGetInteractionModelCatalogVersionV1(String catalogId, String version) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("catalogId", catalogId);
    pathParams.put("version", version);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/api/custom/interactionModel/catalogs/{catalogId}/versions/{version}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.interactionModel.version.CatalogVersionData.class, 200, "Returns the catalog version metadata for the given catalogId and version."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "There is no catalog defined for the catalogId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.interactionModel.version.CatalogVersionData.class, false);
  }

  /**
   * 
   * Get catalog version data of given catalog version. 
   * @param catalogId Unique identifier of the catalog (required)
   * @param version Version for interaction model. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.interactionModel.version.CatalogVersionData
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.interactionModel.version.CatalogVersionData getInteractionModelCatalogVersionV1(String catalogId, String version) throws ServiceException {
    return this.callGetInteractionModelCatalogVersionV1(catalogId, version).getResponse();
  }

  /**
   * 
   * Update description and vendorGuidance string for certain version of a catalog. 
   * @param catalogId Unique identifier of the catalog (required)
   * @param version Version for interaction model. (required)
   * @param catalogUpdate  (optional)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callUpdateInteractionModelCatalogVersionV1(String catalogId, String version, com.amazon.ask.smapi.model.v1.skill.interactionModel.version.CatalogUpdate catalogUpdate) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("catalogId", catalogId);
    pathParams.put("version", version);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/api/custom/interactionModel/catalogs/{catalogId}/versions/{version}/update";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "No Content; Confirms that version is successfully updated."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "There is no catalog defined for the catalogId"));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, catalogUpdate, null, false);
  }

  /**
   * 
   * Update description and vendorGuidance string for certain version of a catalog. 
   * @param catalogId Unique identifier of the catalog (required)
   * @param version Version for interaction model. (required)
   * @param catalogUpdate  (optional)
   * @throws ServiceException if fails to make API call
   */
  public void updateInteractionModelCatalogVersionV1(String catalogId, String version, com.amazon.ask.smapi.model.v1.skill.interactionModel.version.CatalogUpdate catalogUpdate) throws ServiceException {
    this.callUpdateInteractionModelCatalogVersionV1(catalogId, version, catalogUpdate).getResponse();
  }

  /**
   * 
   * Get catalog values from the given catalogId &amp;amp; version. 
   * @param catalogId Unique identifier of the catalog (required)
   * @param version Version for interaction model. (required)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.interactionModel.version.CatalogValues
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.interactionModel.version.CatalogValues> callGetInteractionModelCatalogValuesV1(String catalogId, String version, BigDecimal maxResults, String nextToken) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();

    if(maxResults != null) {
    queryParams.add(new Pair<String, String>("maxResults", maxResults.toString()));
  }

    if(nextToken != null) {
    queryParams.add(new Pair<String, String>("nextToken", nextToken));
  }
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("catalogId", catalogId);
    pathParams.put("version", version);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/api/custom/interactionModel/catalogs/{catalogId}/versions/{version}/values";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.interactionModel.version.CatalogValues.class, 200, "Returns list of catalog values for the given catalogId and version."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "There is no catalog defined for the catalogId"));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.interactionModel.version.CatalogValues.class, false);
  }

  /**
   * 
   * Get catalog values from the given catalogId &amp;amp; version. 
   * @param catalogId Unique identifier of the catalog (required)
   * @param version Version for interaction model. (required)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.interactionModel.version.CatalogValues
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.interactionModel.version.CatalogValues getInteractionModelCatalogValuesV1(String catalogId, String version, BigDecimal maxResults, String nextToken) throws ServiceException {
    return this.callGetInteractionModelCatalogValuesV1(catalogId, version, maxResults, nextToken).getResponse();
  }

  /**
   * 
   * List all catalogs for the vendor. 
   * @param vendorId The vendor ID. (required)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @param sortDirection Sets the sorting direction of the result items. When set to &#39;asc&#39; these items are returned in ascending order of sortField value and when set to &#39;desc&#39; these items are returned in descending order of sortField value. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.ListCatalogResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.ListCatalogResponse> callListInteractionModelCatalogsV1(String vendorId, BigDecimal maxResults, String nextToken, String sortDirection) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();

    if(vendorId != null) {
    queryParams.add(new Pair<String, String>("vendorId", vendorId));
  }

    if(maxResults != null) {
    queryParams.add(new Pair<String, String>("maxResults", maxResults.toString()));
  }

    if(nextToken != null) {
    queryParams.add(new Pair<String, String>("nextToken", nextToken));
  }

    if(sortDirection != null) {
    queryParams.add(new Pair<String, String>("sortDirection", sortDirection));
  }
    Map<String, String> pathParams = new HashMap<String, String>();
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/api/custom/interactionModel/catalogs";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.ListCatalogResponse.class, 200, "Returns list of catalogs for the vendor."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "There is no catalog defined for the catalogId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.ListCatalogResponse.class, false);
  }

  /**
   * 
   * List all catalogs for the vendor. 
   * @param vendorId The vendor ID. (required)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @param sortDirection Sets the sorting direction of the result items. When set to &#39;asc&#39; these items are returned in ascending order of sortField value and when set to &#39;desc&#39; these items are returned in descending order of sortField value. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.ListCatalogResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.ListCatalogResponse listInteractionModelCatalogsV1(String vendorId, BigDecimal maxResults, String nextToken, String sortDirection) throws ServiceException {
    return this.callListInteractionModelCatalogsV1(vendorId, maxResults, nextToken, sortDirection).getResponse();
  }

  /**
   * 
   * Create a new version of catalog within the given catalogId. 
   * @param catalog  (required)
   * @return com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.CatalogResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.CatalogResponse> callCreateInteractionModelCatalogV1(com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.DefinitionData catalog) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/api/custom/interactionModel/catalogs";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.CatalogResponse.class, 200, "Returns the generated catalogId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error e.g. the catalog definition is invalid."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 412, "Precondition failed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, catalog, com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.CatalogResponse.class, false);
  }

  /**
   * 
   * Create a new version of catalog within the given catalogId. 
   * @param catalog  (required)
   * @return com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.CatalogResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.CatalogResponse createInteractionModelCatalogV1(com.amazon.ask.smapi.model.v1.skill.interactionModel.catalog.DefinitionData catalog) throws ServiceException {
    return this.callCreateInteractionModelCatalogV1(catalog).getResponse();
  }

  /**
   * 
   * Get status for given exportId 
   * @param exportId The Export ID. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.ExportResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.ExportResponse> callGetStatusOfExportRequestV1(String exportId) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("exportId", exportId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/exports/{exportId}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.ExportResponse.class, 200, "OK."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.ExportResponse.class, false);
  }

  /**
   * 
   * Get status for given exportId 
   * @param exportId The Export ID. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.ExportResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.ExportResponse getStatusOfExportRequestV1(String exportId) throws ServiceException {
    return this.callGetStatusOfExportRequestV1(exportId).getResponse();
  }

  /**
   * 
   * Get the list of skills for the vendor.
   * @param vendorId The vendor ID. (required)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @param skillId the list of skillIds that you wish to get the summary for. A maximum of 10 skillIds can be specified to get the skill summary in single listSkills call. Please note that this parameter must not be used with &#39;nextToken&#39; or/and &#39;maxResults&#39; parameter. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.ListSkillResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.ListSkillResponse> callListSkillsForVendorV1(String vendorId, String nextToken, BigDecimal maxResults, List<String> skillId) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();

    if(vendorId != null) {
    queryParams.add(new Pair<String, String>("vendorId", vendorId));
  }

    if(nextToken != null) {
    queryParams.add(new Pair<String, String>("nextToken", nextToken));
  }

    if(maxResults != null) {
    queryParams.add(new Pair<String, String>("maxResults", maxResults.toString()));
  }

    if(skillId != null) {
    for (Object param : skillId) {
      queryParams.add(new Pair<String, String>("skillId", param.toString()));
    }
  }
    Map<String, String> pathParams = new HashMap<String, String>();
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.ListSkillResponse.class, 200, "Returns list of skills for the vendor."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.ListSkillResponse.class, false);
  }

  /**
   * 
   * Get the list of skills for the vendor.
   * @param vendorId The vendor ID. (required)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @param skillId the list of skillIds that you wish to get the summary for. A maximum of 10 skillIds can be specified to get the skill summary in single listSkills call. Please note that this parameter must not be used with &#39;nextToken&#39; or/and &#39;maxResults&#39; parameter. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.ListSkillResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.ListSkillResponse listSkillsForVendorV1(String vendorId, String nextToken, BigDecimal maxResults, List<String> skillId) throws ServiceException {
    return this.callListSkillsForVendorV1(vendorId, nextToken, maxResults, skillId).getResponse();
  }

  /**
   * 
   * Get status for given importId. 
   * @param importId The Import ID. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.ImportResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.ImportResponse> callGetImportStatusV1(String importId) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("importId", importId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/imports/{importId}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.ImportResponse.class, 200, "OK."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.ImportResponse.class, false);
  }

  /**
   * 
   * Get status for given importId. 
   * @param importId The Import ID. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.ImportResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.ImportResponse getImportStatusV1(String importId) throws ServiceException {
    return this.callGetImportStatusV1(importId).getResponse();
  }

  /**
   * 
   * Creates a new import for a skill. 
   * @param createSkillWithPackageRequest Defines the request body for createPackage API. (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callCreateSkillPackageV1(com.amazon.ask.smapi.model.v1.skill.CreateSkillWithPackageRequest createSkillWithPackageRequest) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/imports";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 202, "Accepted."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 413, "Payload too large."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, createSkillWithPackageRequest, null, false);
  }

  /**
   * 
   * Creates a new import for a skill. 
   * @param createSkillWithPackageRequest Defines the request body for createPackage API. (required)
   * @throws ServiceException if fails to make API call
   */
  public void createSkillPackageV1(com.amazon.ask.smapi.model.v1.skill.CreateSkillWithPackageRequest createSkillWithPackageRequest) throws ServiceException {
    this.callCreateSkillPackageV1(createSkillWithPackageRequest).getResponse();
  }

  /**
   * 
   * Creates a new skill for given vendorId.
   * @param createSkillRequest Defines the request body for createSkill API. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.CreateSkillResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.CreateSkillResponse> callCreateSkillForVendorV1(com.amazon.ask.smapi.model.v1.skill.CreateSkillRequest createSkillRequest) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.CreateSkillResponse.class, 202, "Accepted; Returns a URL to track the status in 'Location' header."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, createSkillRequest, com.amazon.ask.smapi.model.v1.skill.CreateSkillResponse.class, false);
  }

  /**
   * 
   * Creates a new skill for given vendorId.
   * @param createSkillRequest Defines the request body for createSkill API. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.CreateSkillResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.CreateSkillResponse createSkillForVendorV1(com.amazon.ask.smapi.model.v1.skill.CreateSkillRequest createSkillRequest) throws ServiceException {
    return this.callCreateSkillForVendorV1(createSkillRequest).getResponse();
  }

  /**
   * 
   * Get Alexa hosted skill&#39;s metadata
   * @param skillId The skill ID. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.AlexaHosted.HostedSkillMetadata
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.AlexaHosted.HostedSkillMetadata> callGetAlexaHostedSkillMetadataV1(String skillId) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/alexaHosted";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.AlexaHosted.HostedSkillMetadata.class, 200, "response contains the Alexa hosted skill's metadata"));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error e.g. Authorization Url is invalid"));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.AlexaHosted.HostedSkillMetadata.class, false);
  }

  /**
   * 
   * Get Alexa hosted skill&#39;s metadata
   * @param skillId The skill ID. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.AlexaHosted.HostedSkillMetadata
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.AlexaHosted.HostedSkillMetadata getAlexaHostedSkillMetadataV1(String skillId) throws ServiceException {
    return this.callGetAlexaHostedSkillMetadataV1(skillId).getResponse();
  }

  /**
   * 
   * Generates hosted skill repository credentials to access the hosted skill repository.
   * @param skillId The skill ID. (required)
   * @param hostedSkillRepositoryCredentialsRequest defines the request body for hosted skill repository credentials (required)
   * @return com.amazon.ask.smapi.model.v1.skill.AlexaHosted.HostedSkillRepositoryCredentialsList
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.AlexaHosted.HostedSkillRepositoryCredentialsList> callGenerateCredentialsForAlexaHostedSkillV1(String skillId, com.amazon.ask.smapi.model.v1.skill.AlexaHosted.HostedSkillRepositoryCredentialsRequest hostedSkillRepositoryCredentialsRequest) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/alexaHosted/repository/credentials/generate";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.AlexaHosted.HostedSkillRepositoryCredentialsList.class, 200, "Response contains the hosted skill repository credentials"));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error e.g. Authorization Url is invalid"));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, hostedSkillRepositoryCredentialsRequest, com.amazon.ask.smapi.model.v1.skill.AlexaHosted.HostedSkillRepositoryCredentialsList.class, false);
  }

  /**
   * 
   * Generates hosted skill repository credentials to access the hosted skill repository.
   * @param skillId The skill ID. (required)
   * @param hostedSkillRepositoryCredentialsRequest defines the request body for hosted skill repository credentials (required)
   * @return com.amazon.ask.smapi.model.v1.skill.AlexaHosted.HostedSkillRepositoryCredentialsList
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.AlexaHosted.HostedSkillRepositoryCredentialsList generateCredentialsForAlexaHostedSkillV1(String skillId, com.amazon.ask.smapi.model.v1.skill.AlexaHosted.HostedSkillRepositoryCredentialsRequest hostedSkillRepositoryCredentialsRequest) throws ServiceException {
    return this.callGenerateCredentialsForAlexaHostedSkillV1(skillId, hostedSkillRepositoryCredentialsRequest).getResponse();
  }

  /**
   * End beta test.
   * End a beta test for a given Alexa skill. System will revoke the entitlement of each tester and send access-end notification email to them. 
   * @param skillId The skill ID. (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callEndBetaTestV1(String skillId) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/betaTest/end";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 202, "Accept. Return a URL to track the resource in 'Location' header."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 409, "The request could not be completed due to a conflict with the current state of the target resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, null, false);
  }

  /**
   * End beta test.
   * End a beta test for a given Alexa skill. System will revoke the entitlement of each tester and send access-end notification email to them. 
   * @param skillId The skill ID. (required)
   * @throws ServiceException if fails to make API call
   */
  public void endBetaTestV1(String skillId) throws ServiceException {
    this.callEndBetaTestV1(skillId).getResponse();
  }

  /**
   * Get beta test.
   * Get beta test for a given Alexa skill.
   * @param skillId The skill ID. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.betaTest.BetaTest
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.betaTest.BetaTest> callGetBetaTestV1(String skillId) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/betaTest";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.betaTest.BetaTest.class, 200, "Success."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.betaTest.BetaTest.class, false);
  }

  /**
   * Get beta test.
   * Get beta test for a given Alexa skill.
   * @param skillId The skill ID. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.betaTest.BetaTest
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.betaTest.BetaTest getBetaTestV1(String skillId) throws ServiceException {
    return this.callGetBetaTestV1(skillId).getResponse();
  }

  /**
   * Create beta test.
   * Create a beta test for a given Alexa skill.
   * @param skillId The skill ID. (required)
   * @param createTestBody JSON object containing the details of a beta test used to create the test. (optional)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callCreateBetaTestV1(String skillId, com.amazon.ask.smapi.model.v1.skill.betaTest.TestBody createTestBody) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/betaTest";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "Success. Return a URL to track the resource in 'Location' header."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 409, "The request could not be completed due to a conflict with the current state of the target resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, createTestBody, null, false);
  }

  /**
   * Create beta test.
   * Create a beta test for a given Alexa skill.
   * @param skillId The skill ID. (required)
   * @param createTestBody JSON object containing the details of a beta test used to create the test. (optional)
   * @throws ServiceException if fails to make API call
   */
  public void createBetaTestV1(String skillId, com.amazon.ask.smapi.model.v1.skill.betaTest.TestBody createTestBody) throws ServiceException {
    this.callCreateBetaTestV1(skillId, createTestBody).getResponse();
  }

  /**
   * Update beta test.
   * Update a beta test for a given Alexa skill.
   * @param skillId The skill ID. (required)
   * @param createTestBody JSON object containing the details of a beta test used to create the test. (optional)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callUpdateBetaTestV1(String skillId, com.amazon.ask.smapi.model.v1.skill.betaTest.TestBody createTestBody) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/betaTest";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "Success. No content."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error."));

    return this.executeRequest("PUT", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, createTestBody, null, false);
  }

  /**
   * Update beta test.
   * Update a beta test for a given Alexa skill.
   * @param skillId The skill ID. (required)
   * @param createTestBody JSON object containing the details of a beta test used to create the test. (optional)
   * @throws ServiceException if fails to make API call
   */
  public void updateBetaTestV1(String skillId, com.amazon.ask.smapi.model.v1.skill.betaTest.TestBody createTestBody) throws ServiceException {
    this.callUpdateBetaTestV1(skillId, createTestBody).getResponse();
  }

  /**
   * Start beta test
   * Start a beta test for a given Alexa skill. System will send invitation emails to each tester in the test, and add entitlement on the acceptance. 
   * @param skillId The skill ID. (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callStartBetaTestV1(String skillId) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/betaTest/start";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 202, "Accept. Return a URL to track the resource in 'Location' header."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 409, "The request could not be completed due to a conflict with the current state of the target resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, null, false);
  }

  /**
   * Start beta test
   * Start a beta test for a given Alexa skill. System will send invitation emails to each tester in the test, and add entitlement on the acceptance. 
   * @param skillId The skill ID. (required)
   * @throws ServiceException if fails to make API call
   */
  public void startBetaTestV1(String skillId) throws ServiceException {
    this.callStartBetaTestV1(skillId).getResponse();
  }

  /**
   * Add testers to an existing beta test.
   * Add testers to a beta test for the given Alexa skill.  System will send invitation email to each tester and add entitlement on the acceptance. 
   * @param skillId The skill ID. (required)
   * @param testersRequest JSON object containing the email address of beta testers. (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callAddTestersToBetaTestV1(String skillId, com.amazon.ask.smapi.model.v1.skill.betaTest.testers.TestersList testersRequest) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/betaTest/testers/add";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "Success. No content."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, testersRequest, null, false);
  }

  /**
   * Add testers to an existing beta test.
   * Add testers to a beta test for the given Alexa skill.  System will send invitation email to each tester and add entitlement on the acceptance. 
   * @param skillId The skill ID. (required)
   * @param testersRequest JSON object containing the email address of beta testers. (required)
   * @throws ServiceException if fails to make API call
   */
  public void addTestersToBetaTestV1(String skillId, com.amazon.ask.smapi.model.v1.skill.betaTest.testers.TestersList testersRequest) throws ServiceException {
    this.callAddTestersToBetaTestV1(skillId, testersRequest).getResponse();
  }

  /**
   * List testers.
   * List all testers in a beta test for the given Alexa skill.
   * @param skillId The skill ID. (required)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.betaTest.testers.ListTestersResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.betaTest.testers.ListTestersResponse> callGetListOfTestersV1(String skillId, String nextToken, BigDecimal maxResults) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();

    if(nextToken != null) {
    queryParams.add(new Pair<String, String>("nextToken", nextToken));
  }

    if(maxResults != null) {
    queryParams.add(new Pair<String, String>("maxResults", maxResults.toString()));
  }
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/betaTest/testers";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.betaTest.testers.ListTestersResponse.class, 200, "Success."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Bad request."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.betaTest.testers.ListTestersResponse.class, false);
  }

  /**
   * List testers.
   * List all testers in a beta test for the given Alexa skill.
   * @param skillId The skill ID. (required)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.betaTest.testers.ListTestersResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.betaTest.testers.ListTestersResponse getListOfTestersV1(String skillId, String nextToken, BigDecimal maxResults) throws ServiceException {
    return this.callGetListOfTestersV1(skillId, nextToken, maxResults).getResponse();
  }

  /**
   * Remove testers from an existing beta test.
   * Remove testers from a beta test for the given Alexa skill.  System will send access end email to each tester and remove entitlement for them. 
   * @param skillId The skill ID. (required)
   * @param testersRequest JSON object containing the email address of beta testers. (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callRemoveTestersFromBetaTestV1(String skillId, com.amazon.ask.smapi.model.v1.skill.betaTest.testers.TestersList testersRequest) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/betaTest/testers/remove";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "Success. No content."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, testersRequest, null, false);
  }

  /**
   * Remove testers from an existing beta test.
   * Remove testers from a beta test for the given Alexa skill.  System will send access end email to each tester and remove entitlement for them. 
   * @param skillId The skill ID. (required)
   * @param testersRequest JSON object containing the email address of beta testers. (required)
   * @throws ServiceException if fails to make API call
   */
  public void removeTestersFromBetaTestV1(String skillId, com.amazon.ask.smapi.model.v1.skill.betaTest.testers.TestersList testersRequest) throws ServiceException {
    this.callRemoveTestersFromBetaTestV1(skillId, testersRequest).getResponse();
  }

  /**
   * Request feedback from testers.
   * Request feedback from the testers in a beta test for the given Alexa skill.  System will send notification emails to testers to request feedback. 
   * @param skillId The skill ID. (required)
   * @param testersRequest JSON object containing the email address of beta testers. (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callRequestFeedbackFromTestersV1(String skillId, com.amazon.ask.smapi.model.v1.skill.betaTest.testers.TestersList testersRequest) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/betaTest/testers/requestFeedback";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "Success. No content."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 409, "The request could not be completed due to a conflict with the current state of the target resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, testersRequest, null, false);
  }

  /**
   * Request feedback from testers.
   * Request feedback from the testers in a beta test for the given Alexa skill.  System will send notification emails to testers to request feedback. 
   * @param skillId The skill ID. (required)
   * @param testersRequest JSON object containing the email address of beta testers. (required)
   * @throws ServiceException if fails to make API call
   */
  public void requestFeedbackFromTestersV1(String skillId, com.amazon.ask.smapi.model.v1.skill.betaTest.testers.TestersList testersRequest) throws ServiceException {
    this.callRequestFeedbackFromTestersV1(skillId, testersRequest).getResponse();
  }

  /**
   * Send reminder to testers in a beta test.
   * Send reminder to the testers in a beta test for the given Alexa skill.  System will send invitation email to each tester and add entitlement on the acceptance. 
   * @param skillId The skill ID. (required)
   * @param testersRequest JSON object containing the email address of beta testers. (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callSendReminderToTestersV1(String skillId, com.amazon.ask.smapi.model.v1.skill.betaTest.testers.TestersList testersRequest) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/betaTest/testers/sendReminder";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "Success. No content."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 409, "The request could not be completed due to a conflict with the current state of the target resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, testersRequest, null, false);
  }

  /**
   * Send reminder to testers in a beta test.
   * Send reminder to the testers in a beta test for the given Alexa skill.  System will send invitation email to each tester and add entitlement on the acceptance. 
   * @param skillId The skill ID. (required)
   * @param testersRequest JSON object containing the email address of beta testers. (required)
   * @throws ServiceException if fails to make API call
   */
  public void sendReminderToTestersV1(String skillId, com.amazon.ask.smapi.model.v1.skill.betaTest.testers.TestersList testersRequest) throws ServiceException {
    this.callSendReminderToTestersV1(skillId, testersRequest).getResponse();
  }

  /**
   * 
   * Gets a specific certification resource. The response contains the review tracking information for a skill to show how much time the skill is expected to remain under review by Amazon. Once the review is complete, the response also contains the outcome of the review. Old certifications may not be available, however any ongoing certification would always give a response. If the certification is unavailable the result will return a 404 HTTP status code. 
   * @param skillId The skill ID. (required)
   * @param certificationId Id of the certification. Reserved word identifier of mostRecent can be used to get the most recent certification for the skill. Note that the behavior of the API in this case would be the same as when the actual certification id of the most recent certification is used in the request.  (required)
   * @param acceptLanguage User&#39;s locale/language in context. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.certification.CertificationResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.certification.CertificationResponse> callGetCertificationReviewV1(String skillId, String certificationId, String acceptLanguage) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("certificationId", certificationId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    if (acceptLanguage != null) {
      headerParams.add(new Pair<String, String>("Accept-Language", acceptLanguage));
    }

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/certifications/{certificationId}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.certification.CertificationResponse.class, 200, "Successfully retrieved skill certification information."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Exceeded the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.certification.CertificationResponse.class, false);
  }

  /**
   * 
   * Gets a specific certification resource. The response contains the review tracking information for a skill to show how much time the skill is expected to remain under review by Amazon. Once the review is complete, the response also contains the outcome of the review. Old certifications may not be available, however any ongoing certification would always give a response. If the certification is unavailable the result will return a 404 HTTP status code. 
   * @param skillId The skill ID. (required)
   * @param certificationId Id of the certification. Reserved word identifier of mostRecent can be used to get the most recent certification for the skill. Note that the behavior of the API in this case would be the same as when the actual certification id of the most recent certification is used in the request.  (required)
   * @param acceptLanguage User&#39;s locale/language in context. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.certification.CertificationResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.certification.CertificationResponse getCertificationReviewV1(String skillId, String certificationId, String acceptLanguage) throws ServiceException {
    return this.callGetCertificationReviewV1(skillId, certificationId, acceptLanguage).getResponse();
  }

  /**
   * 
   * Get list of all certifications available for a skill, including information about past certifications and any ongoing certification. The default sort order is descending on skillSubmissionTimestamp for Certifications. 
   * @param skillId The skill ID. (required)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.certification.ListCertificationsResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.certification.ListCertificationsResponse> callGetCertificationsListV1(String skillId, String nextToken, BigDecimal maxResults) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();

    if(nextToken != null) {
    queryParams.add(new Pair<String, String>("nextToken", nextToken));
  }

    if(maxResults != null) {
    queryParams.add(new Pair<String, String>("maxResults", maxResults.toString()));
  }
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/certifications";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.certification.ListCertificationsResponse.class, 200, "Returns list of certifications for the skillId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 400, "Server cannot process the request due to a client error e.g. if any request parameter is invalid like certification Id or pagination token etc. If the maxResults is not in the range of 1 to 50, it also qualifies for this error. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Exceeded the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.certification.ListCertificationsResponse.class, false);
  }

  /**
   * 
   * Get list of all certifications available for a skill, including information about past certifications and any ongoing certification. The default sort order is descending on skillSubmissionTimestamp for Certifications. 
   * @param skillId The skill ID. (required)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.certification.ListCertificationsResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.certification.ListCertificationsResponse getCertificationsListV1(String skillId, String nextToken, BigDecimal maxResults) throws ServiceException {
    return this.callGetCertificationsListV1(skillId, nextToken, maxResults).getResponse();
  }

  /**
   * 
   * Delete the skill and model for given skillId.
   * @param skillId The skill ID. (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callDeleteSkillV1(String skillId) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "Success. No content."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("DELETE", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, null, false);
  }

  /**
   * 
   * Delete the skill and model for given skillId.
   * @param skillId The skill ID. (required)
   * @throws ServiceException if fails to make API call
   */
  public void deleteSkillV1(String skillId) throws ServiceException {
    this.callDeleteSkillV1(skillId).getResponse();
  }

  /**
   * The Intent Request History API provides customers with the aggregated and anonymized transcription of user speech data and intent request details for their skills.
   * 
   * @param skillId The skill ID. (required)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @param sortDirection Sets the sorting direction of the result items. When set to &#39;asc&#39; these items are returned in ascending order of sortField value and when set to &#39;desc&#39; these items are returned in descending order of sortField value. (optional)
   * @param sortField Sets the field on which the sorting would be applied. (optional)
   * @param stage A filter used to retrieve items where the stage is equal to the given value. (optional)
   * @param locale  (optional)
   * @param dialogActName A filter used to retrieve items where the dialogAct name is equal to the given value. * &#x60;Dialog.ElicitSlot&#x60;: Alexa asked the user for the value of a specific slot. (https://developer.amazon.com/docs/custom-skills/dialog-interface-reference.html#elicitslot) * &#x60;Dialog.ConfirmSlot&#x60;: Alexa confirmed the value of a specific slot before continuing with the dialog. (https://developer.amazon.com/docs/custom-skills/dialog-interface-reference.html#confirmslot) * &#x60;Dialog.ConfirmIntent&#x60;: Alexa confirmed the all the information the user has provided for the intent before the skill took action. (https://developer.amazon.com/docs/custom-skills/dialog-interface-reference.html#confirmintent)  (optional)
   * @param intentConfidenceBin  (optional)
   * @param intentName A filter used to retrieve items where the intent name is equal to the given value. (optional)
   * @param intentSlotsName A filter used to retrieve items where the one of the slot names is equal to the given value. (optional)
   * @param interactionType  (optional)
   * @param publicationStatus  (optional)
   * @param utteranceText A filter used to retrieve items where the utterance text contains the given phrase. Each filter value can be at-least 1 character and at-most 100 characters long. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.history.IntentRequests
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.history.IntentRequests> callGetUtteranceDataV1(String skillId, String nextToken, BigDecimal maxResults, String sortDirection, String sortField, List<com.amazon.ask.smapi.model.v1.StageType> stage, List<com.amazon.ask.smapi.model.v1.skill.history.LocaleInQuery> locale, List<com.amazon.ask.smapi.model.v1.skill.history.DialogActName> dialogActName, List<com.amazon.ask.smapi.model.v1.skill.history.IntentConfidenceBin> intentConfidenceBin, List<String> intentName, List<String> intentSlotsName, List<com.amazon.ask.smapi.model.v1.skill.history.InteractionType> interactionType, List<com.amazon.ask.smapi.model.v1.skill.history.PublicationStatus> publicationStatus, List<String> utteranceText) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();

    if(nextToken != null) {
    queryParams.add(new Pair<String, String>("nextToken", nextToken));
  }

    if(maxResults != null) {
    queryParams.add(new Pair<String, String>("maxResults", maxResults.toString()));
  }

    if(sortDirection != null) {
    queryParams.add(new Pair<String, String>("sortDirection", sortDirection));
  }

    if(sortField != null) {
    queryParams.add(new Pair<String, String>("sortField", sortField));
  }

    if(stage != null) {
    for (Object param : stage) {
      queryParams.add(new Pair<String, String>("stage", param.toString()));
    }
  }

    if(locale != null) {
    for (Object param : locale) {
      queryParams.add(new Pair<String, String>("locale", param.toString()));
    }
  }

    if(dialogActName != null) {
    for (Object param : dialogActName) {
      queryParams.add(new Pair<String, String>("dialogAct.name", param.toString()));
    }
  }

    if(intentConfidenceBin != null) {
    for (Object param : intentConfidenceBin) {
      queryParams.add(new Pair<String, String>("intent.confidence.bin", param.toString()));
    }
  }

    if(intentName != null) {
    for (Object param : intentName) {
      queryParams.add(new Pair<String, String>("intent.name", param.toString()));
    }
  }

    if(intentSlotsName != null) {
    for (Object param : intentSlotsName) {
      queryParams.add(new Pair<String, String>("intent.slots.name", param.toString()));
    }
  }

    if(interactionType != null) {
    for (Object param : interactionType) {
      queryParams.add(new Pair<String, String>("interactionType", param.toString()));
    }
  }

    if(publicationStatus != null) {
    for (Object param : publicationStatus) {
      queryParams.add(new Pair<String, String>("publicationStatus", param.toString()));
    }
  }

    if(utteranceText != null) {
    for (Object param : utteranceText) {
      queryParams.add(new Pair<String, String>("utteranceText", param.toString()));
    }
  }
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/history/intentRequests";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.history.IntentRequests.class, 200, "Returns a list of utterance items for the given skill."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Bad Request."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "Unauthorized."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "Skill Not Found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.history.IntentRequests.class, false);
  }

  /**
   * The Intent Request History API provides customers with the aggregated and anonymized transcription of user speech data and intent request details for their skills.
   * 
   * @param skillId The skill ID. (required)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @param sortDirection Sets the sorting direction of the result items. When set to &#39;asc&#39; these items are returned in ascending order of sortField value and when set to &#39;desc&#39; these items are returned in descending order of sortField value. (optional)
   * @param sortField Sets the field on which the sorting would be applied. (optional)
   * @param stage A filter used to retrieve items where the stage is equal to the given value. (optional)
   * @param locale  (optional)
   * @param dialogActName A filter used to retrieve items where the dialogAct name is equal to the given value. * &#x60;Dialog.ElicitSlot&#x60;: Alexa asked the user for the value of a specific slot. (https://developer.amazon.com/docs/custom-skills/dialog-interface-reference.html#elicitslot) * &#x60;Dialog.ConfirmSlot&#x60;: Alexa confirmed the value of a specific slot before continuing with the dialog. (https://developer.amazon.com/docs/custom-skills/dialog-interface-reference.html#confirmslot) * &#x60;Dialog.ConfirmIntent&#x60;: Alexa confirmed the all the information the user has provided for the intent before the skill took action. (https://developer.amazon.com/docs/custom-skills/dialog-interface-reference.html#confirmintent)  (optional)
   * @param intentConfidenceBin  (optional)
   * @param intentName A filter used to retrieve items where the intent name is equal to the given value. (optional)
   * @param intentSlotsName A filter used to retrieve items where the one of the slot names is equal to the given value. (optional)
   * @param interactionType  (optional)
   * @param publicationStatus  (optional)
   * @param utteranceText A filter used to retrieve items where the utterance text contains the given phrase. Each filter value can be at-least 1 character and at-most 100 characters long. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.history.IntentRequests
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.history.IntentRequests getUtteranceDataV1(String skillId, String nextToken, BigDecimal maxResults, String sortDirection, String sortField, List<com.amazon.ask.smapi.model.v1.StageType> stage, List<com.amazon.ask.smapi.model.v1.skill.history.LocaleInQuery> locale, List<com.amazon.ask.smapi.model.v1.skill.history.DialogActName> dialogActName, List<com.amazon.ask.smapi.model.v1.skill.history.IntentConfidenceBin> intentConfidenceBin, List<String> intentName, List<String> intentSlotsName, List<com.amazon.ask.smapi.model.v1.skill.history.InteractionType> interactionType, List<com.amazon.ask.smapi.model.v1.skill.history.PublicationStatus> publicationStatus, List<String> utteranceText) throws ServiceException {
    return this.callGetUtteranceDataV1(skillId, nextToken, maxResults, sortDirection, sortField, stage, locale, dialogActName, intentConfidenceBin, intentName, intentSlotsName, interactionType, publicationStatus, utteranceText).getResponse();
  }

  /**
   * 
   * Creates a new import for a skill with given skillId. 
   * @param updateSkillWithPackageRequest Defines the request body for updatePackage API. (required)
   * @param skillId The skill ID. (required)
   * @param ifMatch Request header that specified an entity tag. The server will update the resource only if the eTag matches with the resource&#39;s current eTag. (optional)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callImportSkillPackageV1(com.amazon.ask.smapi.model.v1.skill.UpdateSkillWithPackageRequest updateSkillWithPackageRequest, String skillId, String ifMatch) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    if (ifMatch != null) {
      headerParams.add(new Pair<String, String>("If-Match", ifMatch));
    }

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/imports";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 202, "Accepted."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 409, "The request could not be completed due to a conflict with the current state of the target resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 413, "Payload too large."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, updateSkillWithPackageRequest, null, false);
  }

  /**
   * 
   * Creates a new import for a skill with given skillId. 
   * @param updateSkillWithPackageRequest Defines the request body for updatePackage API. (required)
   * @param skillId The skill ID. (required)
   * @param ifMatch Request header that specified an entity tag. The server will update the resource only if the eTag matches with the resource&#39;s current eTag. (optional)
   * @throws ServiceException if fails to make API call
   */
  public void importSkillPackageV1(com.amazon.ask.smapi.model.v1.skill.UpdateSkillWithPackageRequest updateSkillWithPackageRequest, String skillId, String ifMatch) throws ServiceException {
    this.callImportSkillPackageV1(updateSkillWithPackageRequest, skillId, ifMatch).getResponse();
  }

  /**
   * 
   * Get analytic metrics report of skill usage.
   * @param skillId The skill ID. (required)
   * @param startTime The start time of query. (required)
   * @param endTime The end time of query (The maximum time duration is 1 week) (required)
   * @param period The aggregation period to use when retrieving the metric, follows ISO_8601#Durations format. (required)
   * @param metric A distinct set of logic which predictably returns a set of data. (required)
   * @param stage The stage of the skill (live, development). (required)
   * @param skillType The type of the skill (custom, smartHome and flashBriefing). (required)
   * @param intent The intent of the skill. (optional)
   * @param locale The locale for the skill. e.g. en-GB, en-US, de-DE and etc. (optional)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.metrics.GetMetricDataResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.metrics.GetMetricDataResponse> callGetSkillMetricsV1(String skillId, OffsetDateTime startTime, OffsetDateTime endTime, String period, String metric, String stage, String skillType, String intent, String locale, BigDecimal maxResults, String nextToken) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();

    if(startTime != null) {
    queryParams.add(new Pair<String, String>("startTime", startTime.toString()));
  }

    if(endTime != null) {
    queryParams.add(new Pair<String, String>("endTime", endTime.toString()));
  }

    if(period != null) {
    queryParams.add(new Pair<String, String>("period", period));
  }

    if(metric != null) {
    queryParams.add(new Pair<String, String>("metric", metric));
  }

    if(stage != null) {
    queryParams.add(new Pair<String, String>("stage", stage));
  }

    if(skillType != null) {
    queryParams.add(new Pair<String, String>("skillType", skillType));
  }

    if(intent != null) {
    queryParams.add(new Pair<String, String>("intent", intent));
  }

    if(locale != null) {
    queryParams.add(new Pair<String, String>("locale", locale));
  }

    if(maxResults != null) {
    queryParams.add(new Pair<String, String>("maxResults", maxResults.toString()));
  }

    if(nextToken != null) {
    queryParams.add(new Pair<String, String>("nextToken", nextToken));
  }
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/metrics";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.metrics.GetMetricDataResponse.class, 200, "Get analytic metrics report successfully."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Bad request due to invalid or missing data."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.metrics.GetMetricDataResponse.class, false);
  }

  /**
   * 
   * Get analytic metrics report of skill usage.
   * @param skillId The skill ID. (required)
   * @param startTime The start time of query. (required)
   * @param endTime The end time of query (The maximum time duration is 1 week) (required)
   * @param period The aggregation period to use when retrieving the metric, follows ISO_8601#Durations format. (required)
   * @param metric A distinct set of logic which predictably returns a set of data. (required)
   * @param stage The stage of the skill (live, development). (required)
   * @param skillType The type of the skill (custom, smartHome and flashBriefing). (required)
   * @param intent The intent of the skill. (optional)
   * @param locale The locale for the skill. e.g. en-GB, en-US, de-DE and etc. (optional)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.metrics.GetMetricDataResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.metrics.GetMetricDataResponse getSkillMetricsV1(String skillId, OffsetDateTime startTime, OffsetDateTime endTime, String period, String metric, String stage, String skillType, String intent, String locale, BigDecimal maxResults, String nextToken) throws ServiceException {
    return this.callGetSkillMetricsV1(skillId, startTime, endTime, period, metric, stage, skillType, intent, locale, maxResults, nextToken).getResponse();
  }

  /**
   * Simulate executing a skill with the given id.
   * This is an asynchronous API that simulates a skill execution in the Alexa eco-system given an utterance text of what a customer would say to Alexa. A successful response will contain a header with the location of the simulation resource. In cases where requests to this API results in an error, the response will contain an error code and a description of the problem. The skill being simulated must be in development stage, and it must also belong to and be enabled by the user of this API. Concurrent requests per user is currently not supported. 
   * @param skillId The skill ID. (required)
   * @param simulationsApiRequest Payload sent to the skill simulation API. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.simulations.SimulationsApiResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.simulations.SimulationsApiResponse> callSimulateSkillV1(String skillId, com.amazon.ask.smapi.model.v1.skill.simulations.SimulationsApiRequest simulationsApiRequest) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/simulations";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.simulations.SimulationsApiResponse.class, 200, "Skill simulation has successfully began."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Bad request due to invalid or missing data."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "API user does not have permission to call this API or is currently in a state that does not allow simulation of this skill. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "The specified skill does not exist."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 409, "This requests conflicts with another one currently being processed. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "API user has exceeded the permitted request rate."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal service error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 503, "Service Unavailable."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, simulationsApiRequest, com.amazon.ask.smapi.model.v1.skill.simulations.SimulationsApiResponse.class, false);
  }

  /**
   * Simulate executing a skill with the given id.
   * This is an asynchronous API that simulates a skill execution in the Alexa eco-system given an utterance text of what a customer would say to Alexa. A successful response will contain a header with the location of the simulation resource. In cases where requests to this API results in an error, the response will contain an error code and a description of the problem. The skill being simulated must be in development stage, and it must also belong to and be enabled by the user of this API. Concurrent requests per user is currently not supported. 
   * @param skillId The skill ID. (required)
   * @param simulationsApiRequest Payload sent to the skill simulation API. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.simulations.SimulationsApiResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.simulations.SimulationsApiResponse simulateSkillV1(String skillId, com.amazon.ask.smapi.model.v1.skill.simulations.SimulationsApiRequest simulationsApiRequest) throws ServiceException {
    return this.callSimulateSkillV1(skillId, simulationsApiRequest).getResponse();
  }

  /**
   * Get the result of a previously executed simulation.
   * This API gets the result of a previously executed simulation. A successful response will contain the status of the executed simulation. If the simulation successfully completed, the response will also contain information related to skill invocation. In cases where requests to this API results in an error, the response will contain an error code and a description of the problem. In cases where the simulation failed, the response will contain a status attribute indicating that a failure occurred and details about what was sent to the skill endpoint. Note that simulation results are stored for 10 minutes. A request for an expired simulation result will return a 404 HTTP status code. 
   * @param skillId The skill ID. (required)
   * @param simulationId Id of the simulation.  (required)
   * @return com.amazon.ask.smapi.model.v1.skill.simulations.SimulationsApiResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.simulations.SimulationsApiResponse> callGetSkillSimulationV1(String skillId, String simulationId) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("simulationId", simulationId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/simulations/{simulationId}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.simulations.SimulationsApiResponse.class, 200, "Successfully retrieved skill simulation information."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "API user does not have permission or is currently in a state that does not allow calls to this API. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "The specified skill or simulation does not exist. The error response will contain a description that indicates the specific resource type that was not found. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "API user has exceeded the permitted request rate."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal service error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.simulations.SimulationsApiResponse.class, false);
  }

  /**
   * Get the result of a previously executed simulation.
   * This API gets the result of a previously executed simulation. A successful response will contain the status of the executed simulation. If the simulation successfully completed, the response will also contain information related to skill invocation. In cases where requests to this API results in an error, the response will contain an error code and a description of the problem. In cases where the simulation failed, the response will contain a status attribute indicating that a failure occurred and details about what was sent to the skill endpoint. Note that simulation results are stored for 10 minutes. A request for an expired simulation result will return a 404 HTTP status code. 
   * @param skillId The skill ID. (required)
   * @param simulationId Id of the simulation.  (required)
   * @return com.amazon.ask.smapi.model.v1.skill.simulations.SimulationsApiResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.simulations.SimulationsApiResponse getSkillSimulationV1(String skillId, String simulationId) throws ServiceException {
    return this.callGetSkillSimulationV1(skillId, simulationId).getResponse();
  }

  /**
   * 
   * Returns the ssl certificate sets currently associated with this skill. Sets consist of one ssl certificate blob associated with a region as well as the default certificate for the skill.
   * @param skillId The skill ID. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.SSLCertificatePayload
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.SSLCertificatePayload> callGetSSLCertificatesV1(String skillId) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/sslCertificateSets/~latest";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.SSLCertificatePayload.class, 200, "Response contains the latest version of the ssl certificates."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.SSLCertificatePayload.class, false);
  }

  /**
   * 
   * Returns the ssl certificate sets currently associated with this skill. Sets consist of one ssl certificate blob associated with a region as well as the default certificate for the skill.
   * @param skillId The skill ID. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.SSLCertificatePayload
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.SSLCertificatePayload getSSLCertificatesV1(String skillId) throws ServiceException {
    return this.callGetSSLCertificatesV1(skillId).getResponse();
  }

  /**
   * 
   * Updates the ssl certificates associated with this skill.
   * @param skillId The skill ID. (required)
   * @param sslCertificatePayload Defines the input/output of the ssl certificates api for a skill. (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callSetSSLCertificatesV1(String skillId, com.amazon.ask.smapi.model.v1.skill.SSLCertificatePayload sslCertificatePayload) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/sslCertificateSets/~latest";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "Accepted; Request was successful and get will now result in the new values."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("PUT", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, sslCertificatePayload, null, false);
  }

  /**
   * 
   * Updates the ssl certificates associated with this skill.
   * @param skillId The skill ID. (required)
   * @param sslCertificatePayload Defines the input/output of the ssl certificates api for a skill. (required)
   * @throws ServiceException if fails to make API call
   */
  public void setSSLCertificatesV1(String skillId, com.amazon.ask.smapi.model.v1.skill.SSLCertificatePayload sslCertificatePayload) throws ServiceException {
    this.callSetSSLCertificatesV1(skillId, sslCertificatePayload).getResponse();
  }

  /**
   * 
   * Deletes the enablement for given skillId/stage and customerId (retrieved from Auth token).
   * @param skillId The skill ID. (required)
   * @param stage Stage for skill. (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callDeleteSkillEnablementV1(String skillId, String stage) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("stage", stage);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/stages/{stage}/enablement";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "No Content; Confirms that enablement is successfully deleted."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("DELETE", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, null, false);
  }

  /**
   * 
   * Deletes the enablement for given skillId/stage and customerId (retrieved from Auth token).
   * @param skillId The skill ID. (required)
   * @param stage Stage for skill. (required)
   * @throws ServiceException if fails to make API call
   */
  public void deleteSkillEnablementV1(String skillId, String stage) throws ServiceException {
    this.callDeleteSkillEnablementV1(skillId, stage).getResponse();
  }

  /**
   * 
   * Checks whether an enablement exist for given skillId/stage and customerId (retrieved from Auth token)
   * @param skillId The skill ID. (required)
   * @param stage Stage for skill. (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callGetSkillEnablementStatusV1(String skillId, String stage) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("stage", stage);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/stages/{stage}/enablement";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "No Content; Confirms that enablement resource exists for given skillId &amp; stage."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, null, false);
  }

  /**
   * 
   * Checks whether an enablement exist for given skillId/stage and customerId (retrieved from Auth token)
   * @param skillId The skill ID. (required)
   * @param stage Stage for skill. (required)
   * @throws ServiceException if fails to make API call
   */
  public void getSkillEnablementStatusV1(String skillId, String stage) throws ServiceException {
    this.callGetSkillEnablementStatusV1(skillId, stage).getResponse();
  }

  /**
   * 
   * Creates/Updates the enablement for given skillId/stage and customerId (retrieved from Auth token)
   * @param skillId The skill ID. (required)
   * @param stage Stage for skill. (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callSetSkillEnablementV1(String skillId, String stage) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("stage", stage);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/stages/{stage}/enablement";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "No Content; Confirms that enablement is successfully created/updated."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 409, "The request could not be completed due to a conflict with the current state of the target resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("PUT", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, null, false);
  }

  /**
   * 
   * Creates/Updates the enablement for given skillId/stage and customerId (retrieved from Auth token)
   * @param skillId The skill ID. (required)
   * @param stage Stage for skill. (required)
   * @throws ServiceException if fails to make API call
   */
  public void setSkillEnablementV1(String skillId, String stage) throws ServiceException {
    this.callSetSkillEnablementV1(skillId, stage).getResponse();
  }

  /**
   * 
   * Creates a new export for a skill with given skillId and stage. 
   * @param skillId The skill ID. (required)
   * @param stage Stage for skill. (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callCreateExportRequestForSkillV1(String skillId, String stage) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("stage", stage);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/stages/{stage}/exports";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 202, "Accepted."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 409, "The request could not be completed due to a conflict with the current state of the target resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, null, false);
  }

  /**
   * 
   * Creates a new export for a skill with given skillId and stage. 
   * @param skillId The skill ID. (required)
   * @param stage Stage for skill. (required)
   * @throws ServiceException if fails to make API call
   */
  public void createExportRequestForSkillV1(String skillId, String stage) throws ServiceException {
    this.callCreateExportRequestForSkillV1(skillId, stage).getResponse();
  }

  /**
   * 
   * Get the list of in-skill products for the skillId.
   * @param skillId The skill ID. (required)
   * @param stage Stage for skill. (required)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @return com.amazon.ask.smapi.model.v1.isp.ListInSkillProductResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.isp.ListInSkillProductResponse> callGetIspListForSkillIdV1(String skillId, String stage, String nextToken, BigDecimal maxResults) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();

    if(nextToken != null) {
    queryParams.add(new Pair<String, String>("nextToken", nextToken));
  }

    if(maxResults != null) {
    queryParams.add(new Pair<String, String>("maxResults", maxResults.toString()));
  }
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("stage", stage);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/stages/{stage}/inSkillProducts";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.isp.ListInSkillProductResponse.class, 200, "Response contains list of in-skill products for the specified skillId and stage."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Bad request. Returned when a required parameter is not present, badly formatted. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "Requested resource not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Too many requests received."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error"));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.isp.ListInSkillProductResponse.class, false);
  }

  /**
   * 
   * Get the list of in-skill products for the skillId.
   * @param skillId The skill ID. (required)
   * @param stage Stage for skill. (required)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @return com.amazon.ask.smapi.model.v1.isp.ListInSkillProductResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.isp.ListInSkillProductResponse getIspListForSkillIdV1(String skillId, String stage, String nextToken, BigDecimal maxResults) throws ServiceException {
    return this.callGetIspListForSkillIdV1(skillId, stage, nextToken, maxResults).getResponse();
  }

  /**
   * Profile a test utterance.
   * This is a synchronous API that profiles an utterance against interaction model.
   * @param profileNluRequest Payload sent to the profile nlu API. (required)
   * @param skillId The skill ID. (required)
   * @param stage Stage for skill. (required)
   * @param locale The locale for the model requested e.g. en-GB, en-US, de-DE. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.evaluations.ProfileNluResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.evaluations.ProfileNluResponse> callProfileNluV1(com.amazon.ask.smapi.model.v1.skill.evaluations.ProfileNluRequest profileNluRequest, String skillId, String stage, String locale) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("stage", stage);
    pathParams.put("locale", locale);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/stages/{stage}/interactionModel/locales/{locale}/profileNlu";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.evaluations.ProfileNluResponse.class, 200, "Profiled utterance against interaction model and returned nlu response successfully."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Bad request due to invalid or missing data."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 409, "This requests conflicts with another one currently being processed. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "API user has exceeded the permitted request rate."));
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 500, "Internal service error."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, profileNluRequest, com.amazon.ask.smapi.model.v1.skill.evaluations.ProfileNluResponse.class, false);
  }

  /**
   * Profile a test utterance.
   * This is a synchronous API that profiles an utterance against interaction model.
   * @param profileNluRequest Payload sent to the profile nlu API. (required)
   * @param skillId The skill ID. (required)
   * @param stage Stage for skill. (required)
   * @param locale The locale for the model requested e.g. en-GB, en-US, de-DE. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.evaluations.ProfileNluResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.evaluations.ProfileNluResponse profileNluV1(com.amazon.ask.smapi.model.v1.skill.evaluations.ProfileNluRequest profileNluRequest, String skillId, String stage, String locale) throws ServiceException {
    return this.callProfileNluV1(profileNluRequest, skillId, stage, locale).getResponse();
  }

  /**
   * 
   * List private distribution accounts. 
   * @param skillId The skill ID. (required)
   * @param stage Stage for skill. (required)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.Private.ListPrivateDistributionAccountsResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.Private.ListPrivateDistributionAccountsResponse> callListPrivateDistributionAccountsV1(String skillId, String stage, String nextToken, BigDecimal maxResults) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();

    if(nextToken != null) {
    queryParams.add(new Pair<String, String>("nextToken", nextToken));
  }

    if(maxResults != null) {
    queryParams.add(new Pair<String, String>("maxResults", maxResults.toString()));
  }
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("stage", stage);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/stages/{stage}/privateDistributionAccounts";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.Private.ListPrivateDistributionAccountsResponse.class, 200, "Returns list of private distribution accounts on success."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.Private.ListPrivateDistributionAccountsResponse.class, false);
  }

  /**
   * 
   * List private distribution accounts. 
   * @param skillId The skill ID. (required)
   * @param stage Stage for skill. (required)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.Private.ListPrivateDistributionAccountsResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.Private.ListPrivateDistributionAccountsResponse listPrivateDistributionAccountsV1(String skillId, String stage, String nextToken, BigDecimal maxResults) throws ServiceException {
    return this.callListPrivateDistributionAccountsV1(skillId, stage, nextToken, maxResults).getResponse();
  }

  /**
   * 
   * Remove an id from the private distribution accounts. 
   * @param skillId The skill ID. (required)
   * @param stage Stage for skill. (required)
   * @param id ARN that a skill can be privately distributed to. (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callDeletePrivateDistributionAccountIdV1(String skillId, String stage, String id) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("stage", stage);
    pathParams.put("id", id);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/stages/{stage}/privateDistributionAccounts/{id}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "Success."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("DELETE", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, null, false);
  }

  /**
   * 
   * Remove an id from the private distribution accounts. 
   * @param skillId The skill ID. (required)
   * @param stage Stage for skill. (required)
   * @param id ARN that a skill can be privately distributed to. (required)
   * @throws ServiceException if fails to make API call
   */
  public void deletePrivateDistributionAccountIdV1(String skillId, String stage, String id) throws ServiceException {
    this.callDeletePrivateDistributionAccountIdV1(skillId, stage, id).getResponse();
  }

  /**
   * 
   * Add an id to the private distribution accounts. 
   * @param skillId The skill ID. (required)
   * @param stage Stage for skill. (required)
   * @param id ARN that a skill can be privately distributed to. (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callSetPrivateDistributionAccountIdV1(String skillId, String stage, String id) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("stage", stage);
    pathParams.put("id", id);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/stages/{stage}/privateDistributionAccounts/{id}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "Success."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("PUT", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, null, false);
  }

  /**
   * 
   * Add an id to the private distribution accounts. 
   * @param skillId The skill ID. (required)
   * @param stage Stage for skill. (required)
   * @param id ARN that a skill can be privately distributed to. (required)
   * @throws ServiceException if fails to make API call
   */
  public void setPrivateDistributionAccountIdV1(String skillId, String stage, String id) throws ServiceException {
    this.callSetPrivateDistributionAccountIdV1(skillId, stage, id).getResponse();
  }

  /**
   * 
   * Delete AccountLinking information of a skill for the given stage. 
   * @param skillId The skill ID. (required)
   * @param stageV2 Stages of a skill including the new certified stage. * &#x60;development&#x60; - skills which are currently in development corresponds to this stage. * &#x60;certified&#x60; -  skills which have completed certification and ready for publishing corresponds to this stage. * &#x60;live&#x60; - skills which are currently live corresponds to this stage.  (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callDeleteAccountLinkingInfoV1(String skillId, String stageV2) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("stageV2", stageV2);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/stages/{stageV2}/accountLinkingClient";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "Success. No content."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The specified skill/stage/accountLinkingClient doesn't exist."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("DELETE", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, null, false);
  }

  /**
   * 
   * Delete AccountLinking information of a skill for the given stage. 
   * @param skillId The skill ID. (required)
   * @param stageV2 Stages of a skill including the new certified stage. * &#x60;development&#x60; - skills which are currently in development corresponds to this stage. * &#x60;certified&#x60; -  skills which have completed certification and ready for publishing corresponds to this stage. * &#x60;live&#x60; - skills which are currently live corresponds to this stage.  (required)
   * @throws ServiceException if fails to make API call
   */
  public void deleteAccountLinkingInfoV1(String skillId, String stageV2) throws ServiceException {
    this.callDeleteAccountLinkingInfoV1(skillId, stageV2).getResponse();
  }

  /**
   * 
   * Get AccountLinking information for the skill. 
   * @param skillId The skill ID. (required)
   * @param stageV2 Stages of a skill including the new certified stage. * &#x60;development&#x60; - skills which are currently in development corresponds to this stage. * &#x60;certified&#x60; -  skills which have completed certification and ready for publishing corresponds to this stage. * &#x60;live&#x60; - skills which are currently live corresponds to this stage.  (required)
   * @return com.amazon.ask.smapi.model.v1.skill.accountLinking.AccountLinkingResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.accountLinking.AccountLinkingResponse> callGetAccountLinkingInfoV1(String skillId, String stageV2) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("stageV2", stageV2);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/stages/{stageV2}/accountLinkingClient";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.accountLinking.AccountLinkingResponse.class, 200, "Returns AccountLinking response of the skill."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.accountLinking.AccountLinkingResponse.class, false);
  }

  /**
   * 
   * Get AccountLinking information for the skill. 
   * @param skillId The skill ID. (required)
   * @param stageV2 Stages of a skill including the new certified stage. * &#x60;development&#x60; - skills which are currently in development corresponds to this stage. * &#x60;certified&#x60; -  skills which have completed certification and ready for publishing corresponds to this stage. * &#x60;live&#x60; - skills which are currently live corresponds to this stage.  (required)
   * @return com.amazon.ask.smapi.model.v1.skill.accountLinking.AccountLinkingResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.accountLinking.AccountLinkingResponse getAccountLinkingInfoV1(String skillId, String stageV2) throws ServiceException {
    return this.callGetAccountLinkingInfoV1(skillId, stageV2).getResponse();
  }

  /**
   * 
   * Create AccountLinking information for the skill. 
   * @param skillId The skill ID. (required)
   * @param stageV2 Stages of a skill including the new certified stage. * &#x60;development&#x60; - skills which are currently in development corresponds to this stage. * &#x60;certified&#x60; -  skills which have completed certification and ready for publishing corresponds to this stage. * &#x60;live&#x60; - skills which are currently live corresponds to this stage.  (required)
   * @param accountLinkingRequest The fields required to create accountLinking partner. (required)
   * @param ifMatch Request header that specified an entity tag. The server will update the resource only if the eTag matches with the resource&#39;s current eTag. (optional)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callUpdateAccountLinkingInfoV1(String skillId, String stageV2, com.amazon.ask.smapi.model.v1.skill.accountLinking.AccountLinkingRequest accountLinkingRequest, String ifMatch) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("stageV2", stageV2);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    if (ifMatch != null) {
      headerParams.add(new Pair<String, String>("If-Match", ifMatch));
    }

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/stages/{stageV2}/accountLinkingClient";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "Success"));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error e.g. Authorization Url is invalid."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 412, "Precondition failed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("PUT", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, accountLinkingRequest, null, false);
  }

  /**
   * 
   * Create AccountLinking information for the skill. 
   * @param skillId The skill ID. (required)
   * @param stageV2 Stages of a skill including the new certified stage. * &#x60;development&#x60; - skills which are currently in development corresponds to this stage. * &#x60;certified&#x60; -  skills which have completed certification and ready for publishing corresponds to this stage. * &#x60;live&#x60; - skills which are currently live corresponds to this stage.  (required)
   * @param accountLinkingRequest The fields required to create accountLinking partner. (required)
   * @param ifMatch Request header that specified an entity tag. The server will update the resource only if the eTag matches with the resource&#39;s current eTag. (optional)
   * @throws ServiceException if fails to make API call
   */
  public void updateAccountLinkingInfoV1(String skillId, String stageV2, com.amazon.ask.smapi.model.v1.skill.accountLinking.AccountLinkingRequest accountLinkingRequest, String ifMatch) throws ServiceException {
    this.callUpdateAccountLinkingInfoV1(skillId, stageV2, accountLinkingRequest, ifMatch).getResponse();
  }

  /**
   * 
   * Gets the &#x60;InteractionModel&#x60; for the skill in the given stage. The path params **skillId**, **stage** and **locale** are required. 
   * @param skillId The skill ID. (required)
   * @param stageV2 Stages of a skill including the new certified stage. * &#x60;development&#x60; - skills which are currently in development corresponds to this stage. * &#x60;certified&#x60; -  skills which have completed certification and ready for publishing corresponds to this stage. * &#x60;live&#x60; - skills which are currently live corresponds to this stage.  (required)
   * @param locale The locale for the model requested e.g. en-GB, en-US, de-DE. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.interactionModel.InteractionModelData
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.interactionModel.InteractionModelData> callGetInteractionModelV1(String skillId, String stageV2, String locale) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("stageV2", stageV2);
    pathParams.put("locale", locale);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/stages/{stageV2}/interactionModel/locales/{locale}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.interactionModel.InteractionModelData.class, 200, "Returns interaction model object on success"));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The specified skill doesn't exist or there is no model defined for the locale."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.interactionModel.InteractionModelData.class, false);
  }

  /**
   * 
   * Gets the &#x60;InteractionModel&#x60; for the skill in the given stage. The path params **skillId**, **stage** and **locale** are required. 
   * @param skillId The skill ID. (required)
   * @param stageV2 Stages of a skill including the new certified stage. * &#x60;development&#x60; - skills which are currently in development corresponds to this stage. * &#x60;certified&#x60; -  skills which have completed certification and ready for publishing corresponds to this stage. * &#x60;live&#x60; - skills which are currently live corresponds to this stage.  (required)
   * @param locale The locale for the model requested e.g. en-GB, en-US, de-DE. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.interactionModel.InteractionModelData
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.interactionModel.InteractionModelData getInteractionModelV1(String skillId, String stageV2, String locale) throws ServiceException {
    return this.callGetInteractionModelV1(skillId, stageV2, locale).getResponse();
  }

  /**
   * 
   * Get the latest metadata for the interaction model resource for the given stage 
   * @param skillId The skill ID. (required)
   * @param stageV2 Stages of a skill including the new certified stage. * &#x60;development&#x60; - skills which are currently in development corresponds to this stage. * &#x60;certified&#x60; -  skills which have completed certification and ready for publishing corresponds to this stage. * &#x60;live&#x60; - skills which are currently live corresponds to this stage.  (required)
   * @param locale The locale for the model requested e.g. en-GB, en-US, de-DE. (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callGetInteractionModelMetadataV1(String skillId, String stageV2, String locale) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("stageV2", stageV2);
    pathParams.put("locale", locale);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/stages/{stageV2}/interactionModel/locales/{locale}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "success. There is no content but returns etag"));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The specified skill or stage or locale does not exist"));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("HEAD", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, null, false);
  }

  /**
   * 
   * Get the latest metadata for the interaction model resource for the given stage 
   * @param skillId The skill ID. (required)
   * @param stageV2 Stages of a skill including the new certified stage. * &#x60;development&#x60; - skills which are currently in development corresponds to this stage. * &#x60;certified&#x60; -  skills which have completed certification and ready for publishing corresponds to this stage. * &#x60;live&#x60; - skills which are currently live corresponds to this stage.  (required)
   * @param locale The locale for the model requested e.g. en-GB, en-US, de-DE. (required)
   * @throws ServiceException if fails to make API call
   */
  public void getInteractionModelMetadataV1(String skillId, String stageV2, String locale) throws ServiceException {
    this.callGetInteractionModelMetadataV1(skillId, stageV2, locale).getResponse();
  }

  /**
   * 
   * Creates an &#x60;InteractionModel&#x60; for the skill. 
   * @param skillId The skill ID. (required)
   * @param stageV2 Stages of a skill including the new certified stage. * &#x60;development&#x60; - skills which are currently in development corresponds to this stage. * &#x60;certified&#x60; -  skills which have completed certification and ready for publishing corresponds to this stage. * &#x60;live&#x60; - skills which are currently live corresponds to this stage.  (required)
   * @param locale The locale for the model requested e.g. en-GB, en-US, de-DE. (required)
   * @param interactionModel  (required)
   * @param ifMatch Request header that specified an entity tag. The server will update the resource only if the eTag matches with the resource&#39;s current eTag. (optional)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callSetInteractionModelV1(String skillId, String stageV2, String locale, com.amazon.ask.smapi.model.v1.skill.interactionModel.InteractionModelData interactionModel, String ifMatch) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("stageV2", stageV2);
    pathParams.put("locale", locale);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    if (ifMatch != null) {
      headerParams.add(new Pair<String, String>("If-Match", ifMatch));
    }

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/stages/{stageV2}/interactionModel/locales/{locale}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 202, "Returns build status location link on success."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error e.g. the input interaction model is invalid"));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The specified skill or stage or locale does not exist"));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 412, "Precondition failed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("PUT", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, interactionModel, null, false);
  }

  /**
   * 
   * Creates an &#x60;InteractionModel&#x60; for the skill. 
   * @param skillId The skill ID. (required)
   * @param stageV2 Stages of a skill including the new certified stage. * &#x60;development&#x60; - skills which are currently in development corresponds to this stage. * &#x60;certified&#x60; -  skills which have completed certification and ready for publishing corresponds to this stage. * &#x60;live&#x60; - skills which are currently live corresponds to this stage.  (required)
   * @param locale The locale for the model requested e.g. en-GB, en-US, de-DE. (required)
   * @param interactionModel  (required)
   * @param ifMatch Request header that specified an entity tag. The server will update the resource only if the eTag matches with the resource&#39;s current eTag. (optional)
   * @throws ServiceException if fails to make API call
   */
  public void setInteractionModelV1(String skillId, String stageV2, String locale, com.amazon.ask.smapi.model.v1.skill.interactionModel.InteractionModelData interactionModel, String ifMatch) throws ServiceException {
    this.callSetInteractionModelV1(skillId, stageV2, locale, interactionModel, ifMatch).getResponse();
  }

  /**
   * 
   * Get the list of interactionModel versions of a skill for the vendor.
   * @param skillId The skill ID. (required)
   * @param stageV2 Stages of a skill including the new certified stage. * &#x60;development&#x60; - skills which are currently in development corresponds to this stage. * &#x60;certified&#x60; -  skills which have completed certification and ready for publishing corresponds to this stage. * &#x60;live&#x60; - skills which are currently live corresponds to this stage.  (required)
   * @param locale The locale for the model requested e.g. en-GB, en-US, de-DE. (required)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @param sortDirection Sets the sorting direction of the result items. When set to &#39;asc&#39; these items are returned in ascending order of sortField value and when set to &#39;desc&#39; these items are returned in descending order of sortField value. (optional)
   * @param sortField Sets the field on which the sorting would be applied. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.interactionModel.version.ListResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.interactionModel.version.ListResponse> callListInteractionModelVersionsV1(String skillId, String stageV2, String locale, String nextToken, BigDecimal maxResults, String sortDirection, String sortField) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();

    if(nextToken != null) {
    queryParams.add(new Pair<String, String>("nextToken", nextToken));
  }

    if(maxResults != null) {
    queryParams.add(new Pair<String, String>("maxResults", maxResults.toString()));
  }

    if(sortDirection != null) {
    queryParams.add(new Pair<String, String>("sortDirection", sortDirection));
  }

    if(sortField != null) {
    queryParams.add(new Pair<String, String>("sortField", sortField));
  }
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("stageV2", stageV2);
    pathParams.put("locale", locale);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/stages/{stageV2}/interactionModel/locales/{locale}/versions";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.interactionModel.version.ListResponse.class, 200, "Returns list of interactionModel versions of a skill for the vendor."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error e.g. the input interaction model is invalid."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The specified skill doesn't exist or there is no model defined for the locale."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.interactionModel.version.ListResponse.class, false);
  }

  /**
   * 
   * Get the list of interactionModel versions of a skill for the vendor.
   * @param skillId The skill ID. (required)
   * @param stageV2 Stages of a skill including the new certified stage. * &#x60;development&#x60; - skills which are currently in development corresponds to this stage. * &#x60;certified&#x60; -  skills which have completed certification and ready for publishing corresponds to this stage. * &#x60;live&#x60; - skills which are currently live corresponds to this stage.  (required)
   * @param locale The locale for the model requested e.g. en-GB, en-US, de-DE. (required)
   * @param nextToken When response to this API call is truncated (that is, isTruncated response element value is true), the response also includes the nextToken element. The value of nextToken can be used in the next request as the continuation-token to list the next set of objects. The continuation token is an opaque value that Skill Management API understands. Token has expiry of 24 hours. (optional)
   * @param maxResults Sets the maximum number of results returned in the response body. If you want to retrieve fewer than upper limit of 50 results, you can add this parameter to your request. maxResults should not exceed the upper limit. The response might contain fewer results than maxResults, but it will never contain more. If there are additional results that satisfy the search criteria, but these results were not returned, the response contains isTruncated &#x3D; true. (optional)
   * @param sortDirection Sets the sorting direction of the result items. When set to &#39;asc&#39; these items are returned in ascending order of sortField value and when set to &#39;desc&#39; these items are returned in descending order of sortField value. (optional)
   * @param sortField Sets the field on which the sorting would be applied. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.interactionModel.version.ListResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.interactionModel.version.ListResponse listInteractionModelVersionsV1(String skillId, String stageV2, String locale, String nextToken, BigDecimal maxResults, String sortDirection, String sortField) throws ServiceException {
    return this.callListInteractionModelVersionsV1(skillId, stageV2, locale, nextToken, maxResults, sortDirection, sortField).getResponse();
  }

  /**
   * 
   * Gets the specified version &#x60;InteractionModel&#x60; of a skill for the vendor. Use &#x60;~current&#x60; as version parameter to get the current version model. 
   * @param skillId The skill ID. (required)
   * @param stageV2 Stages of a skill including the new certified stage. * &#x60;development&#x60; - skills which are currently in development corresponds to this stage. * &#x60;certified&#x60; -  skills which have completed certification and ready for publishing corresponds to this stage. * &#x60;live&#x60; - skills which are currently live corresponds to this stage.  (required)
   * @param locale The locale for the model requested e.g. en-GB, en-US, de-DE. (required)
   * @param version Version for interaction model. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.interactionModel.InteractionModelData
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.interactionModel.InteractionModelData> callGetInteractionModelVersionV1(String skillId, String stageV2, String locale, String version) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("stageV2", stageV2);
    pathParams.put("locale", locale);
    pathParams.put("version", version);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/stages/{stageV2}/interactionModel/locales/{locale}/versions/{version}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.interactionModel.InteractionModelData.class, 200, "Returns interaction model object on success."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error e.g. the input interaction model is invalid."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The specified skill doesn't exist or there is no model defined for the locale or version."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.interactionModel.InteractionModelData.class, false);
  }

  /**
   * 
   * Gets the specified version &#x60;InteractionModel&#x60; of a skill for the vendor. Use &#x60;~current&#x60; as version parameter to get the current version model. 
   * @param skillId The skill ID. (required)
   * @param stageV2 Stages of a skill including the new certified stage. * &#x60;development&#x60; - skills which are currently in development corresponds to this stage. * &#x60;certified&#x60; -  skills which have completed certification and ready for publishing corresponds to this stage. * &#x60;live&#x60; - skills which are currently live corresponds to this stage.  (required)
   * @param locale The locale for the model requested e.g. en-GB, en-US, de-DE. (required)
   * @param version Version for interaction model. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.interactionModel.InteractionModelData
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.interactionModel.InteractionModelData getInteractionModelVersionV1(String skillId, String stageV2, String locale, String version) throws ServiceException {
    return this.callGetInteractionModelVersionV1(skillId, stageV2, locale, version).getResponse();
  }

  /**
   * 
   * Returns the skill manifest for given skillId and stage.
   * @param skillId The skill ID. (required)
   * @param stageV2 Stages of a skill including the new certified stage. * &#x60;development&#x60; - skills which are currently in development corresponds to this stage. * &#x60;certified&#x60; -  skills which have completed certification and ready for publishing corresponds to this stage. * &#x60;live&#x60; - skills which are currently live corresponds to this stage.  (required)
   * @return com.amazon.ask.smapi.model.v1.skill.Manifest.SkillManifestEnvelope
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.Manifest.SkillManifestEnvelope> callGetSkillManifestV1(String skillId, String stageV2) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("stageV2", stageV2);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/stages/{stageV2}/manifest";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.Manifest.SkillManifestEnvelope.class, 200, "Response contains the latest version of skill manifest."));
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 303, "See Other"));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.Manifest.SkillManifestEnvelope.class, false);
  }

  /**
   * 
   * Returns the skill manifest for given skillId and stage.
   * @param skillId The skill ID. (required)
   * @param stageV2 Stages of a skill including the new certified stage. * &#x60;development&#x60; - skills which are currently in development corresponds to this stage. * &#x60;certified&#x60; -  skills which have completed certification and ready for publishing corresponds to this stage. * &#x60;live&#x60; - skills which are currently live corresponds to this stage.  (required)
   * @return com.amazon.ask.smapi.model.v1.skill.Manifest.SkillManifestEnvelope
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.Manifest.SkillManifestEnvelope getSkillManifestV1(String skillId, String stageV2) throws ServiceException {
    return this.callGetSkillManifestV1(skillId, stageV2).getResponse();
  }

  /**
   * 
   * Updates skill manifest for given skillId and stage.
   * @param skillId The skill ID. (required)
   * @param stageV2 Stages of a skill including the new certified stage. * &#x60;development&#x60; - skills which are currently in development corresponds to this stage. * &#x60;certified&#x60; -  skills which have completed certification and ready for publishing corresponds to this stage. * &#x60;live&#x60; - skills which are currently live corresponds to this stage.  (required)
   * @param updateSkillRequest Defines the request body for updateSkill API. (required)
   * @param ifMatch Request header that specified an entity tag. The server will update the resource only if the eTag matches with the resource&#39;s current eTag. (optional)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callUpdateSkillManifestV1(String skillId, String stageV2, com.amazon.ask.smapi.model.v1.skill.Manifest.SkillManifestEnvelope updateSkillRequest, String ifMatch) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("stageV2", stageV2);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    if (ifMatch != null) {
      headerParams.add(new Pair<String, String>("If-Match", ifMatch));
    }

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/stages/{stageV2}/manifest";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 202, "Accepted; Returns a URL to track the status in 'Location' header."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 409, "The request could not be completed due to a conflict with the current state of the target resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 412, "Precondition failed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("PUT", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, updateSkillRequest, null, false);
  }

  /**
   * 
   * Updates skill manifest for given skillId and stage.
   * @param skillId The skill ID. (required)
   * @param stageV2 Stages of a skill including the new certified stage. * &#x60;development&#x60; - skills which are currently in development corresponds to this stage. * &#x60;certified&#x60; -  skills which have completed certification and ready for publishing corresponds to this stage. * &#x60;live&#x60; - skills which are currently live corresponds to this stage.  (required)
   * @param updateSkillRequest Defines the request body for updateSkill API. (required)
   * @param ifMatch Request header that specified an entity tag. The server will update the resource only if the eTag matches with the resource&#39;s current eTag. (optional)
   * @throws ServiceException if fails to make API call
   */
  public void updateSkillManifestV1(String skillId, String stageV2, com.amazon.ask.smapi.model.v1.skill.Manifest.SkillManifestEnvelope updateSkillRequest, String ifMatch) throws ServiceException {
    this.callUpdateSkillManifestV1(skillId, stageV2, updateSkillRequest, ifMatch).getResponse();
  }

  /**
   * Validate a skill.
   * This is an asynchronous API which allows a skill developer to execute various validations against their skill. 
   * @param validationsApiRequest Payload sent to the skill validation API. (required)
   * @param skillId The skill ID. (required)
   * @param stage Stage for skill. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.validations.ValidationsApiResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.validations.ValidationsApiResponse> callSubmitSkillValidationV1(com.amazon.ask.smapi.model.v1.skill.validations.ValidationsApiRequest validationsApiRequest, String skillId, String stage) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("stage", stage);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/stages/{stage}/validations";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.validations.ValidationsApiResponse.class, 202, "Skill validation has successfully begun."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "API user does not have permission or is currently in a state that does not allow calls to this API. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "The specified skill, stage or validation does not exist. The error response will contain a description that indicates the specific resource type that was not found. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 409, "This requests conflicts with another one currently being processed. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "API user has exceeded the permitted request rate."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal service error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 503, "Service Unavailable."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, validationsApiRequest, com.amazon.ask.smapi.model.v1.skill.validations.ValidationsApiResponse.class, false);
  }

  /**
   * Validate a skill.
   * This is an asynchronous API which allows a skill developer to execute various validations against their skill. 
   * @param validationsApiRequest Payload sent to the skill validation API. (required)
   * @param skillId The skill ID. (required)
   * @param stage Stage for skill. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.validations.ValidationsApiResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.validations.ValidationsApiResponse submitSkillValidationV1(com.amazon.ask.smapi.model.v1.skill.validations.ValidationsApiRequest validationsApiRequest, String skillId, String stage) throws ServiceException {
    return this.callSubmitSkillValidationV1(validationsApiRequest, skillId, stage).getResponse();
  }

  /**
   * Get the result of a previously executed validation.
   * This API gets the result of a previously executed validation. A successful response will contain the status of the executed validation. If the validation successfully completed, the response will also contain information related to executed validations. In cases where requests to this API results in an error, the response will contain a description of the problem. In cases where the validation failed, the response will contain a status attribute indicating that a failure occurred. Note that validation results are stored for 60 minutes. A request for an expired validation result will return a 404 HTTP status code. 
   * @param skillId The skill ID. (required)
   * @param validationId Id of the validation. Reserved word identifier of mostRecent can be used to get the most recent validation for the skill and stage. Note that the behavior of the API in this case would be the same as when the actual validation id of the most recent validation is used in the request.  (required)
   * @param stage Stage for skill. (required)
   * @param acceptLanguage User&#39;s locale/language in context. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.validations.ValidationsApiResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.validations.ValidationsApiResponse> callGetSkillValidationsV1(String skillId, String validationId, String stage, String acceptLanguage) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    pathParams.put("validationId", validationId);
    pathParams.put("stage", stage);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    if (acceptLanguage != null) {
      headerParams.add(new Pair<String, String>("Accept-Language", acceptLanguage));
    }

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/stages/{stage}/validations/{validationId}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.validations.ValidationsApiResponse.class, 200, "Successfully retrieved skill validation information."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "API user does not have permission or is currently in a state that does not allow calls to this API. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 404, "The specified skill, stage, or validation does not exist. The error response will contain a description that indicates the specific resource type that was not found. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 409, "This requests conflicts with another one currently being processed. "));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "API user has exceeded the permitted request rate."));
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 500, "Internal service error."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.validations.ValidationsApiResponse.class, false);
  }

  /**
   * Get the result of a previously executed validation.
   * This API gets the result of a previously executed validation. A successful response will contain the status of the executed validation. If the validation successfully completed, the response will also contain information related to executed validations. In cases where requests to this API results in an error, the response will contain a description of the problem. In cases where the validation failed, the response will contain a status attribute indicating that a failure occurred. Note that validation results are stored for 60 minutes. A request for an expired validation result will return a 404 HTTP status code. 
   * @param skillId The skill ID. (required)
   * @param validationId Id of the validation. Reserved word identifier of mostRecent can be used to get the most recent validation for the skill and stage. Note that the behavior of the API in this case would be the same as when the actual validation id of the most recent validation is used in the request.  (required)
   * @param stage Stage for skill. (required)
   * @param acceptLanguage User&#39;s locale/language in context. (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.validations.ValidationsApiResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.validations.ValidationsApiResponse getSkillValidationsV1(String skillId, String validationId, String stage, String acceptLanguage) throws ServiceException {
    return this.callGetSkillValidationsV1(skillId, validationId, stage, acceptLanguage).getResponse();
  }

  /**
   * 
   * Get the status of skill resource and its sub-resources for a given skillId.
   * @param skillId The skill ID. (required)
   * @param resource Resource name for which status information is desired. It is an optional, filtering parameter and can be used more than once, to retrieve status for all the desired (sub)resources only, in single API call. If this parameter is not specified, status for all the resources/sub-resources will be returned.  (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.SkillStatus
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.SkillStatus> callGetSkillStatusV1(String skillId, String resource) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();

    if(resource != null) {
    queryParams.add(new Pair<String, String>("resource", resource));
  }
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/status";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.SkillStatus.class, 200, "Returns status for skill resource and sub-resources."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.SkillStatus.class, false);
  }

  /**
   * 
   * Get the status of skill resource and its sub-resources for a given skillId.
   * @param skillId The skill ID. (required)
   * @param resource Resource name for which status information is desired. It is an optional, filtering parameter and can be used more than once, to retrieve status for all the desired (sub)resources only, in single API call. If this parameter is not specified, status for all the resources/sub-resources will be returned.  (optional)
   * @return com.amazon.ask.smapi.model.v1.skill.SkillStatus
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.SkillStatus getSkillStatusV1(String skillId, String resource) throws ServiceException {
    return this.callGetSkillStatusV1(skillId, resource).getResponse();
  }

  /**
   * 
   * Submit the skill for certification. 
   * @param skillId The skill ID. (required)
   * @param submitSkillForCertificationRequest Defines the request body for submitSkillForCertification API. (optional)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callSubmitSkillForCertificationV1(String skillId, com.amazon.ask.smapi.model.v1.skill.SubmitSkillForCertificationRequest submitSkillForCertificationRequest) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/submit";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 202, "Success. There is no content but returns Location in the header."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, submitSkillForCertificationRequest, null, false);
  }

  /**
   * 
   * Submit the skill for certification. 
   * @param skillId The skill ID. (required)
   * @param submitSkillForCertificationRequest Defines the request body for submitSkillForCertification API. (optional)
   * @throws ServiceException if fails to make API call
   */
  public void submitSkillForCertificationV1(String skillId, com.amazon.ask.smapi.model.v1.skill.SubmitSkillForCertificationRequest submitSkillForCertificationRequest) throws ServiceException {
    this.callSubmitSkillForCertificationV1(skillId, submitSkillForCertificationRequest).getResponse();
  }

  /**
   * 
   * Withdraws the skill from certification. 
   * @param skillId The skill ID. (required)
   * @param withdrawRequest The reason and message (in case of OTHER) to withdraw a skill. (required)
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<Void> callWithdrawSkillFromCertificationV1(String skillId, com.amazon.ask.smapi.model.v1.skill.WithdrawRequest withdrawRequest) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("skillId", skillId);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/{skillId}/withdraw";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(null, 204, "Success."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 403, "The operation being requested is not allowed."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 404, "The resource being requested is not found."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, withdrawRequest, null, false);
  }

  /**
   * 
   * Withdraws the skill from certification. 
   * @param skillId The skill ID. (required)
   * @param withdrawRequest The reason and message (in case of OTHER) to withdraw a skill. (required)
   * @throws ServiceException if fails to make API call
   */
  public void withdrawSkillFromCertificationV1(String skillId, com.amazon.ask.smapi.model.v1.skill.WithdrawRequest withdrawRequest) throws ServiceException {
    this.callWithdrawSkillFromCertificationV1(skillId, withdrawRequest).getResponse();
  }

  /**
   * 
   * Creates a new uploadUrl. 
   * @return com.amazon.ask.smapi.model.v1.skill.UploadResponse
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.UploadResponse> callCreateUploadUrlV1() throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/skills/uploads";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.UploadResponse.class, 201, "Created."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceeds the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("POST", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.UploadResponse.class, false);
  }

  /**
   * 
   * Creates a new uploadUrl. 
   * @return com.amazon.ask.smapi.model.v1.skill.UploadResponse
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.UploadResponse createUploadUrlV1() throws ServiceException {
    return this.callCreateUploadUrlV1().getResponse();
  }

  /**
   * 
   * Get the list of Vendor information. 
   * @return com.amazon.ask.smapi.model.v1.vendorManagement.Vendors
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.vendorManagement.Vendors> callGetVendorListV1() throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/vendors";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.vendorManagement.Vendors.class, 200, "Return vendor information on success."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.Error.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.vendorManagement.Vendors.class, false);
  }

  /**
   * 
   * Get the list of Vendor information. 
   * @return com.amazon.ask.smapi.model.v1.vendorManagement.Vendors
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.vendorManagement.Vendors getVendorListV1() throws ServiceException {
    return this.callGetVendorListV1().getResponse();
  }

  /**
   * 
   * Get the current user permissions about Alexa hosted skill features.
   * @param vendorId vendorId (required)
   * @param permission The permission of a hosted skill feature that customer needs to check. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.AlexaHosted.HostedSkillPermission
   * @throws ServiceException if fails to make API call
   */
  public ApiResponse<com.amazon.ask.smapi.model.v1.skill.AlexaHosted.HostedSkillPermission> callGetAlexaHostedSkillUserPermissionsV1(String vendorId, String permission) throws ServiceException {
    List<Pair<String, String>> queryParams = new ArrayList<Pair<String, String>>();
    Map<String, String> pathParams = new HashMap<String, String>();
    pathParams.put("vendorId", vendorId);
    pathParams.put("permission", permission);
    List<Pair<String, String>> headerParams = new ArrayList<Pair<String, String>>();
    headerParams.add(new Pair<String, String>("Content-type", "application/json"));

    String accessToken = lwaClient.getAccessTokenForRefreshToken();
    headerParams.add(new Pair<>("Authorization", "Bearer " + accessToken));

    String path = "/v1/vendors/{vendorId}/alexaHosted/permissions/{permission}";

    List<ServiceClientResponse> serviceResponseDefinitions = new ArrayList<>();
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.AlexaHosted.HostedSkillPermission.class, 200, "response contains the user's permission of hosted skill features"));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.BadRequestError.class, 400, "Server cannot process the request due to a client error e.g. Authorization Url is invalid"));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 401, "The auth token is invalid/expired or doesn't have access to the resource."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 429, "Exceed the permitted request limit. Throttling criteria includes total requests, per API, ClientId, and CustomerId."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 500, "Internal Server Error."));
    serviceResponseDefinitions.add(new ServiceClientResponse(com.amazon.ask.smapi.model.v1.skill.StandardizedError.class, 503, "Service Unavailable."));

    return this.executeRequest("GET", this.apiEndpoint, path, queryParams, headerParams,
      pathParams, serviceResponseDefinitions, null, com.amazon.ask.smapi.model.v1.skill.AlexaHosted.HostedSkillPermission.class, false);
  }

  /**
   * 
   * Get the current user permissions about Alexa hosted skill features.
   * @param vendorId vendorId (required)
   * @param permission The permission of a hosted skill feature that customer needs to check. (required)
   * @return com.amazon.ask.smapi.model.v1.skill.AlexaHosted.HostedSkillPermission
   * @throws ServiceException if fails to make API call
   */
  public com.amazon.ask.smapi.model.v1.skill.AlexaHosted.HostedSkillPermission getAlexaHostedSkillUserPermissionsV1(String vendorId, String permission) throws ServiceException {
    return this.callGetAlexaHostedSkillUserPermissionsV1(vendorId, permission).getResponse();
  }

}
