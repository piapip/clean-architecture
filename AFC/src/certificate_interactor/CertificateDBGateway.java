package certificate_interactor;

public interface CertificateDBGateway {
	public Certificate getCertificate(String certificateId);
	public boolean updateCertificate(String certificateId, Certificate newCertificate);
}
