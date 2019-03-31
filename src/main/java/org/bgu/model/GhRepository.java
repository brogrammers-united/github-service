package org.bgu.model;

import org.bgu.model.json.GhRepositorySerializer;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using=GhRepositorySerializer.class)
@Document(collection = "gh_repository")
public class GhRepository {

	@Id
	private ObjectId id;

	@Indexed(unique = true)
	private final String name;

	@Indexed(unique = true)
	private String username;

	private final String description;

	private final String homepage;

	private final boolean isPrivate;

	private final boolean issues;

	private final boolean projects;

	private final boolean wiki;

	private final int teamId;

	private final boolean autoInit;

	private final String gitignoreTemplate;

	private final String licenseTemplate;

	private final boolean allowSquashMerge;

	private final boolean allowMergeCommit;

	private final boolean allowRebaseMerge;

	@JsonCreator
	public GhRepository(@JsonProperty("name") String name, @JsonProperty("description") String description, @JsonProperty("homepage") String homepage, @JsonProperty("private") boolean isPrivate, @JsonProperty("has_issues") boolean issues,
			@JsonProperty("has_projects") boolean projects, @JsonProperty("has_wiki") boolean wiki, @JsonProperty("team_id") int teamId, @JsonProperty("auto_init") boolean autoInit, @JsonProperty("gitignore_template") String gitignoreTemplate,
			@JsonProperty("licence_template") String licenseTemplate, @JsonProperty("allow_squash_merge") boolean allowSquashMerge, @JsonProperty("allow_merge_commit") boolean allowMergeCommit, @JsonProperty("allow_rebase_merge") boolean allowRebaseMerge) {
		super();
		this.name = name;
		this.description = description;
		this.homepage = homepage;
		this.isPrivate = isPrivate;
		this.issues = issues;
		this.projects = projects;
		this.wiki = wiki;
		this.teamId = teamId;
		this.autoInit = autoInit;
		this.gitignoreTemplate = gitignoreTemplate;
		this.licenseTemplate = licenseTemplate;
		this.allowSquashMerge = allowSquashMerge;
		this.allowMergeCommit = allowMergeCommit;
		this.allowRebaseMerge = allowRebaseMerge;
	}

	@PersistenceConstructor
	public GhRepository(String name, String username, String description, String homepage, boolean isPrivate,
			boolean issues, boolean projects, boolean wiki, int teamId, boolean autoInit, String gitignoreTemplate,
			String licenseTemplate, boolean allowSquashMerge, boolean allowMergeCommit, boolean allowRebaseMerge) {
		super();
		this.name = name;
		this.username = username;
		this.description = description;
		this.homepage = homepage;
		this.isPrivate = isPrivate;
		this.issues = issues;
		this.projects = projects;
		this.wiki = wiki;
		this.teamId = teamId;
		this.autoInit = autoInit;
		this.gitignoreTemplate = gitignoreTemplate;
		this.licenseTemplate = licenseTemplate;
		this.allowSquashMerge = allowSquashMerge;
		this.allowMergeCommit = allowMergeCommit;
		this.allowRebaseMerge = allowRebaseMerge;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getHomepage() {
		return homepage;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public boolean hasIssues() {
		return issues;
	}

	public boolean hasProjects() {
		return projects;
	}

	public boolean hasWiki() {
		return wiki;
	}

	public int getTeamId() {
		return teamId;
	}

	public boolean isAutoInit() {
		return autoInit;
	}

	public String getGitignoreTemplate() {
		return gitignoreTemplate;
	}

	public String getLicenseTemplate() {
		return licenseTemplate;
	}

	public boolean isAllowSquashMerge() {
		return allowSquashMerge;
	}

	public boolean isAllowMergeCommit() {
		return allowMergeCommit;
	}

	public boolean isAllowRebaseMerge() {
		return allowRebaseMerge;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isIssues() {
		return issues;
	}

	public boolean isProjects() {
		return projects;
	}

	public boolean isWiki() {
		return wiki;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (allowMergeCommit ? 1231 : 1237);
		result = prime * result + (allowRebaseMerge ? 1231 : 1237);
		result = prime * result + (allowSquashMerge ? 1231 : 1237);
		result = prime * result + (autoInit ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((gitignoreTemplate == null) ? 0 : gitignoreTemplate.hashCode());
		result = prime * result + ((homepage == null) ? 0 : homepage.hashCode());
		result = prime * result + (isPrivate ? 1231 : 1237);
		result = prime * result + (issues ? 1231 : 1237);
		result = prime * result + ((licenseTemplate == null) ? 0 : licenseTemplate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (projects ? 1231 : 1237);
		result = prime * result + teamId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + (wiki ? 1231 : 1237);
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
		GhRepository other = (GhRepository) obj;
		if (allowMergeCommit != other.allowMergeCommit)
			return false;
		if (allowRebaseMerge != other.allowRebaseMerge)
			return false;
		if (allowSquashMerge != other.allowSquashMerge)
			return false;
		if (autoInit != other.autoInit)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (gitignoreTemplate == null) {
			if (other.gitignoreTemplate != null)
				return false;
		} else if (!gitignoreTemplate.equals(other.gitignoreTemplate))
			return false;
		if (homepage == null) {
			if (other.homepage != null)
				return false;
		} else if (!homepage.equals(other.homepage))
			return false;
		if (isPrivate != other.isPrivate)
			return false;
		if (issues != other.issues)
			return false;
		if (licenseTemplate == null) {
			if (other.licenseTemplate != null)
				return false;
		} else if (!licenseTemplate.equals(other.licenseTemplate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (projects != other.projects)
			return false;
		if (teamId != other.teamId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (wiki != other.wiki)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GhRepository [name=");
		builder.append(name);
		builder.append(", username=");
		builder.append(username);
		builder.append(", description=");
		builder.append(description);
		builder.append(", homepage=");
		builder.append(homepage);
		builder.append(", isPrivate=");
		builder.append(isPrivate);
		builder.append(", issues=");
		builder.append(issues);
		builder.append(", projects=");
		builder.append(projects);
		builder.append(", wiki=");
		builder.append(wiki);
		builder.append(", teamId=");
		builder.append(teamId);
		builder.append(", autoInit=");
		builder.append(autoInit);
		builder.append(", gitignoreTemplate=");
		builder.append(gitignoreTemplate);
		builder.append(", licenseTemplate=");
		builder.append(licenseTemplate);
		builder.append(", allowSquashMerge=");
		builder.append(allowSquashMerge);
		builder.append(", allowMergeCommit=");
		builder.append(allowMergeCommit);
		builder.append(", allowRebaseMerge=");
		builder.append(allowRebaseMerge);
		builder.append("]");
		return builder.toString();
	}

}
