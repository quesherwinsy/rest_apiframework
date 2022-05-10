package pojo;

import java.util.List;

public class AddClient {
	private String client_id;
	private String client_name;
	private List<String> redirect_uris;
	private String website_uri;
	private String description;
	private String logo_uri;
	private Boolean consent_required;
	private String client_group;
	private String token_endpoint_auth_method;

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public List<String> getRedirect_uris() {
		return redirect_uris;
	}

	public void setRedirect_uris(List<String> redirect_uris) {
		this.redirect_uris = redirect_uris;
	}

	public String getWebsite_uri() {
		return website_uri;
	}

	public void setWebsite_uri(String website_uri) {
		this.website_uri = website_uri;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogo_uri() {
		return logo_uri;
	}

	public void setLogo_uri(String logo_uri) {
		this.logo_uri = logo_uri;
	}

	public Boolean getConsent_required() {
		return consent_required;
	}

	public void setConsent_required(Boolean consent_required) {
		this.consent_required = consent_required;
	}

	public String getClient_group() {
		return client_group;
	}

	public void setClient_group(String client_group) {
		this.client_group = client_group;
	}

	public String getToken_endpoint_auth_method() {
		return token_endpoint_auth_method;
	}

	public void setToken_endpoint_auth_method(String token_endpoint_auth_method) {
		this.token_endpoint_auth_method = token_endpoint_auth_method;
	}

}
