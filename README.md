# Job-Portal-Job-Dekho
Job Dekho is an online job portal connecting job seekers with employers in an efficient and user-friendly way. It allows job seekers to search, apply, and manage profiles while employers can post jobs, find candidates, and streamline recruitment. The platform ensure secure, role-based access with Java, Spring Boot, MySQL, and JWT for authentication
 Job Portal: Job Dekho - Overview and Detailed Description
Job Dekho is an online job portal built to efficiently connect job seekers with potential employers. It serves as a comprehensive platform where job seekers can search for opportunities, apply for positions, and manage their professional profiles, while employers can post job openings, screen candidates, and streamline their recruitment processes. The portal focuses on user-friendliness, security, and efficiency for both job seekers and employers.

Key Features
1. User Roles
Job Seeker:

Users registered as job seekers can:
Browse job listings
Apply for jobs
Manage their profiles
Upload resumes
Set preferences for job alerts and notifications
Employer/Recruiter:

Employers can:
Create accounts to post jobs
Search for candidates
View applicant profiles
Schedule interviews
Communicate directly with job seekers through the portal
Admin:

Admins have overarching control to:
Manage job seekers and employers
Oversee the platform’s operation
Resolve disputes
Ensure compliance and moderation of content posted
2. Job Seeker Features
Profile Management:

Job seekers can create detailed profiles including:
Full Name, Contact Information, and Location
Resume Upload: Resumes can be uploaded in various formats like PDF or Word.
LinkedIn/GitHub Integration: Profiles can include links to LinkedIn and GitHub for enhanced visibility.
Preferred Job Role and Location: Users can specify their preferred roles and job locations.
Experience and Education: Users can add professional experience, educational qualifications, and certifications.
Job Search and Application:

Advanced Search Filters: Search for jobs based on filters like location, company, job type (full-time, part-time, internships), and salary range.
Job Alerts: Get notifications about new job postings that match the user's preferences.
Bookmarking Jobs: Job seekers can bookmark jobs for future reference.
One-Click Apply: Users can easily apply to jobs using their pre-uploaded profiles and resumes.
Interview Scheduler: A built-in tool that helps coordinate interviews between job seekers and employers, simplifying the scheduling process.

3. Employer Features
Job Posting:

Employers can create and customize detailed job listings that include:

Job title
Responsibilities
Qualifications
Salary range
Job location
Customizable Job Listings: Employers can include information about the company’s culture, values, and perks to attract the right candidates.

Candidate Search:

Profile Search: Employers can filter and search the database for job seekers by criteria such as skills, experience, and location.
Resume Downloads: Employers have access to the resumes and professional profiles of candidates.
Applicant Tracking:

Employers can:
Track the status of each application
Schedule interviews directly from the platform
Communicate with candidates throughout the recruitment process
4. Admin Features
User Management: Admins have the authority to manage all platform users (job seekers and employers), ensuring the quality and compliance of the platform's users.

Job and Content Moderation: Admins can review job postings, moderate content, and resolve user disputes. They also prevent fraudulent or inappropriate job posts from being published.

Reporting and Analytics: The platform provides admins with analytics on job postings, applications, user engagement, and overall platform performance.

5. Security Features
Password Encryption and Security:

User credentials are secured using encrypted password encoders like BCrypt, which ensures data privacy and protection.
JWT Authentication:

The platform uses JWT (JSON Web Token) for secure user authentication. This ensures that only verified users can access their accounts and sensitive data, reducing the risk of identity theft.
Role-Based Access Control:

Different user roles (Job Seeker, Employer, Admin) have varying levels of access and permissions, ensuring that security is maintained across the platform.
6. Technologies Used
Backend:

The backend is developed using Java and Spring Boot, offering a robust, scalable, and secure framework for managing APIs, handling data, and user authentication.
Database:

A relational database, such as MySQL, is used to store user information, job postings, applications, and other platform data.
Spring Security:

The platform uses Spring Security for authentication and authorization, providing features like password encoding and JWT token-based security.
Postman for API Testing:

During development, APIs are tested using Postman to ensure they function correctly. This includes endpoints for user registration, job posting, search functionalities, and more.
Conclusion
Job Dekho provides a comprehensive and secure environment for both job seekers and employers to interact. With user-friendly interfaces, advanced search options, and robust security features like JWT authentication and role-based access control, the platform ensures a seamless experience for all users. Whether it’s job searching, candidate recruitment, or application tracking, Job Dekho facilitates the entire process, making it easier, faster, and more efficient.
