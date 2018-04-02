<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/student-xml">
<html>
<body bgcolor="cyan">
	<h3>Available Departments, branches and courses</h3>
	<ol>
	<xsl:for-each select="department">
		<li><xsl:value-of select="dname" /> - Dept. No:<u><xsl:value-of select="dno" /></u><br />
		<xsl:variable name="did" select="dno" />
		<ol type="a">
		<xsl:for-each select="/student-xml/branch">
			<xsl:if test="dno=$did">
				<li><xsl:value-of select="bname" /> - Branch No:<u><xsl:value-of select="bcode" /></u><br />
				<xsl:variable name="bid" select="bcode" />
				<xsl:variable name="cid" select="/student-xml/branch_course[bcode=$bid]/ccode" />
				<ul>
					<xsl:for-each select="/student-xml/course">
						<xsl:if test="ccode=$cid">
							<li><xsl:value-of select="cname" /> : <u><xsl:value-of select="ccode" /></u> Credits=<xsl:value-of select="credits" /></li>
						</xsl:if>
					</xsl:for-each>
				</ul>
				</li>
			</xsl:if>
		</xsl:for-each>
		</ol>
		</li>
	</xsl:for-each>
	</ol>
	<h3>Student Details</h3>
	<ol>
	<xsl:for-each select="student">
		<li><u><xsl:value-of select="rollno" /></u> : <xsl:value-of select="name" /> DOB:<xsl:value-of select="dob" /><br />
		<ol type="a">
			<xsl:variable name="sid" select="rollno" />
			<xsl:for-each select="/student-xml/enrolls[rollno=$sid]" >
				<li><u><xsl:value-of select="ccode"/></u> Grade: <xsl:value-of select="grade" />. 
				<xsl:if test="grade='U'">
					Failed <xsl:value-of select="sess" /> session . Reenroll in next Session
				</xsl:if>
				<xsl:if test="grade!='U'">
					Completed <xsl:value-of select="sess" /> session .
				</xsl:if>
				</li>
			</xsl:for-each>
		</ol>
		</li>
	</xsl:for-each>
	</ol>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
