package edu.axboot.domain.education;

import com.chequer.axboot.core.annotations.ColumnPosition;
import edu.axboot.domain.BaseJpaModel;
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
public class EducationTeach extends BaseJpaModel<Long> {

	@Id
	@Column(name = "ID", precision = 19, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ColumnPosition(1)
	private Long id;

	@Column(name = "COMPANY_NM", length = 30, nullable = false)
	@ColumnPosition(2)
	private String companyNm;

	@Column(name = "CEO", length = 30)
	@ColumnPosition(3)
	private String ceo;

	@Column(name = "BIZNO", length = 10)
	@ColumnPosition(4)
	private String bizno;

	@Column(name = "TEL", length = 18)
	@ColumnPosition(5)
	private String tel;

	@Column(name = "ZIP", length = 7)
	@ColumnPosition(6)
	private String zip;

	@Column(name = "ADDRESS", length = 200)
	@ColumnPosition(7)
	private String address;

	@Column(name = "ADDRESS_DETAIL", length = 200)
	@ColumnPosition(8)
	private String addressDetail;

	@Column(name = "EMAIL", length = 50)
	@ColumnPosition(9)
	private String email;

	@Column(name = "REMARK", length = 500)
	@ColumnPosition(10)
	private String remark;

	@Column(name = "USE_YN", length = 1)
	@ColumnPosition(11)
	private String useYn;

	@Override
	public Long getId() {
		return id;
	}

}