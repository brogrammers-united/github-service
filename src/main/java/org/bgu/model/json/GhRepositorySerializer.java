package org.bgu.model.json;

import java.io.IOException;

import org.bgu.model.GhRepository;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class GhRepositorySerializer extends StdSerializer<GhRepository> {

	private static final long serialVersionUID = 1L;

	public GhRepositorySerializer() {
		this(null);
	}

	public GhRepositorySerializer(Class<GhRepository> t) {
		super(t);
	}

	@Override
	public void serialize(GhRepository value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		gen.writeStringField("name", value.getName());
		if (StringUtils.hasText(value.getDescription()))
			gen.writeStringField("description", value.getDescription());
		if (StringUtils.hasText(value.getHomepage()))
			gen.writeStringField("homepage", value.getHomepage());
		gen.writeBooleanField("private", value.isPrivate());
		gen.writeBooleanField("has_issues", value.hasIssues());
		gen.writeBooleanField("has_projects", value.hasProjects());
		gen.writeBooleanField("has_wiki", value.hasWiki());
		if (value.getTeamId() != 0)
			gen.writeNumberField("team_id", value.getTeamId());
		gen.writeBooleanField("auto_init", value.isAutoInit());
		if (StringUtils.hasText(value.getGitignoreTemplate()))
			gen.writeStringField("gitignore_template", value.getGitignoreTemplate());
		if (StringUtils.hasText(value.getLicenseTemplate()))
			gen.writeStringField("license_template", value.getLicenseTemplate());
		gen.writeBooleanField("allow_squash_merge", value.isAllowSquashMerge());
		gen.writeBooleanField("allow_merge_commit", value.isAllowMergeCommit());
		gen.writeBooleanField("allow_rebase_merge", value.isAllowRebaseMerge());
		gen.writeEndObject();
	}

}
