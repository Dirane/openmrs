/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.api.db;

import java.util.Date;

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.OpenmrsObject;
import org.openmrs.User;
import org.openmrs.util.Security;

/**
 * This class holds the minimal amount of data necessary to change a user's password without using a
 * PreparedStatement or putting the password in the User class. This should never be used by
 * anything except for UserDAO and UserService methods that change passwords.
 *
 * @since 1.5
 */
public class LoginCredential extends BaseOpenmrsObject implements OpenmrsObject {
	
	private Integer userId;
	
	private String hashedPassword;
	
	private String salt;
	
	private String secretQuestion;
	
	private String secretAnswer;
	
	private User changedBy;
	
	private Date dateChanged;
	
	public LoginCredential() {
	}
	
	/**
	 * @return the changedBy
	 */
	public User getChangedBy() {
		return changedBy;
	}
	
	/**
	 * @param changedBy the changedBy to set
	 */
	public void setChangedBy(User changedBy) {
		this.changedBy = changedBy;
	}
	
	/**
	 * @return the dateChanged
	 */
	public Date getDateChanged() {
		return dateChanged;
	}
	
	/**
	 * @param dateChanged the dateChanged to set
	 */
	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}
	
	/**
	 * @return the password
	 */
	public String getHashedPassword() {
		return hashedPassword;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setHashedPassword(String password) {
		this.hashedPassword = password;
	}
	
	/**
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}
	
	/**
	 * @param salt the salt to set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	/**
	 * @return the secretAnswer
	 */
	public String getSecretAnswer() {
		return secretAnswer;
	}
	
	/**
	 * @param secretAnswer the secretAnswer to set
	 */
	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}
	
	/**
	 * @return the secretQuestion
	 */
	public String getSecretQuestion() {
		return secretQuestion;
	}
	
	/**
	 * @param secretQuestion the secretQuestion to set
	 */
	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}
	
	/**
	 * @param pw
	 * @return Whether pw is the correct cleartext password for this user
	 */
	public boolean checkPassword(String pw) {
		return Security.hashMatches(getHashedPassword(), pw + getSalt());
	}
	
	/**
	 * @see org.openmrs.OpenmrsObject#getId()
	 */
	public Integer getId() {
		return userId;
	}
	
	/**
	 * @see org.openmrs.OpenmrsObject#setId(java.lang.Integer)
	 */
	public void setId(Integer id) {
		setUserId(id);
	}
}
