package org.bgu.model;

import org.bgu.model.json.GhRepositoryResponseDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

@JsonDeserialize(using=GhRepositoryResponseDeserializer.class)
public class GhRepositoryResponse {

	private final String id;

	private final String name;

	private final String url;

	private final String cloneUrl;

	private final String sshCloneUrl;

	private final boolean isPrivate;

	private final String owner;

	public GhRepositoryResponse(String id, String name, String url, String cloneUrl, String sshCloneUrl, boolean isPrivate, String owner) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.cloneUrl = cloneUrl;
		this.sshCloneUrl = sshCloneUrl;
		this.isPrivate = isPrivate;
		this.owner = owner;
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

	public boolean isPrivate() {
		return isPrivate;
	}

	public String getOwner() {
		return owner;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GhRepositoryResponse that = (GhRepositoryResponse) o;
		return isPrivate == that.isPrivate &&
				Objects.equals(id, that.id) &&
				Objects.equals(name, that.name) &&
				Objects.equals(url, that.url) &&
				Objects.equals(cloneUrl, that.cloneUrl) &&
				Objects.equals(sshCloneUrl, that.sshCloneUrl) &&
				Objects.equals(owner, that.owner);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, url, cloneUrl, sshCloneUrl, isPrivate, owner);
	}
}
