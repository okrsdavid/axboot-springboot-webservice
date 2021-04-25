package edu.axboot.domain.education;


import edu.axboot.domain.SimpleJpaModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Setter
@Getter
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "EDUCATION_TEACH")
public class EducationTeachGrid extends SimpleJpaModel<Long> {

	@Id
	@Column(name = "ID", precision = 19, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "COMPANY_NM", length = 30)
	private String companyNm;

	@Column(name = "CEO", length = 30)
	private String ceo;

	@Column(name = "BIZNO", length = 10)
	private String bizno;

	@Column(name = "TEL", length = 18)
	private String tel;

	@Column(name = "ZIP", length = 7)
	private String zip;

	@Column(name = "ADDRESS", length = 200)
	private String address;

	@Column(name = "ADDRESS_DETAIL", length = 200)
	private String addressDetail;

	@Column(name = "EMAIL", length = 50)
	private String email;

	@Column(name = "REMARK", length = 500)
	private String remark;

	@Column(name = "USE_YN", length = 1)
	private String useYn;


	@Override
	public Long getId() {
		return id;
	}

}