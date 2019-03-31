package org.bgu.model;

import org.bgu.model.json.GhRepositoryResponseDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using=GhRepositoryResponseDeserializer.class)
public class GhRepositoryResponse {

	private final String id;

	private final String name;

	private final String url;

	private final String cloneUrl;

	private final String sshCloneUrl;

	public GhRepositoryResponse(String id, String name, String url, String cloneUrl, String sshCloneUrl) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.cloneUrl = cloneUrl;
		this.sshCloneUrl = sshCloneUrl;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public String getCloneUrl() {
		return cloneUrl;
	}

	public String getSshCloneUrl() {
		return sshCloneUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cloneUrl == null) ? 0 : cloneUrl.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sshCloneUrl == null) ? 0 : sshCloneUrl.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GhRepositoryResponse other = (GhRepositoryResponse) obj;
		if (cloneUrl == null) {
			if (other.cloneUrl != null)
				return false;
		} else if (!cloneUrl.equals(other.cloneUrl))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sshCloneUrl == null) {
			if (other.sshCloneUrl != null)
				return false;
		} else if (!sshCloneUrl.equals(other.sshCloneUrl))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GhRepositoryResponse [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", url=");
		builder.append(url);
		builder.append(", cloneUrl=");
		builder.append(cloneUrl);
		builder.append(", sshCloneUrl=");
		builder.append(sshCloneUrl);
		builder.append("]");
		return builder.toString();
	}

}
