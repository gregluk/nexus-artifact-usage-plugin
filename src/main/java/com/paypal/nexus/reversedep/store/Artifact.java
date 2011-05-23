package com.paypal.nexus.reversedep.store;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "node")
public class Artifact {
	private String groupId;
	private String artifactId;
	private String version;
	private String text;
	
	public Artifact(String groupId, String artifactId, String version) {
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.version = version;
		
		this.text = groupId+":"+artifactId+":"+version;
	}
	
	public Artifact(String gav) {
		String[] gavPieces = gav.split(":");
		if (gavPieces.length != 3) {
			throw new IllegalArgumentException("GAV parameter must be in the form <groupId>:<artifactId>:version");
		}
		this.groupId = gavPieces[0];
		this.artifactId = gavPieces[1];
		this.version = gavPieces[2];
	}

	public String getGroupId() {
		return groupId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public String getVersion() {
		return version;
	}
	
	public String toString() {
		return this.groupId+":"+this.artifactId+":"+this.version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((artifactId == null) ? 0 : artifactId.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		Artifact other = (Artifact) obj;
		if (artifactId == null) {
			if (other.artifactId != null)
				return false;
		} else if (!artifactId.equals(other.artifactId))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
	
}
