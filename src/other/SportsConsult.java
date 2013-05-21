package other;

import java.sql.Timestamp;

/**
 * SportsConsult entity. @author MyEclipse Persistence Tools
 */
public class SportsConsult extends AbstractSportsConsult implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public SportsConsult() {
	}

	/** full constructor */
	public SportsConsult(String sportsConsultTitle,
			String sportsConsultContent, String sportsType,
			Timestamp sportsConsultCreatedTime, Integer sportsConsultCreatedBy,
			String sportsConsultCreatedByName,
			Timestamp sportsConsultUpdatedTime, Integer sportsConsultUpdatedBy,
			String sportsConsultUpdatedByName, String sportsConsultDepartCode) {
		super(sportsConsultTitle, sportsConsultContent, sportsType,
				sportsConsultCreatedTime, sportsConsultCreatedBy,
				sportsConsultCreatedByName, sportsConsultUpdatedTime,
				sportsConsultUpdatedBy, sportsConsultUpdatedByName,
				sportsConsultDepartCode);
	}

}
