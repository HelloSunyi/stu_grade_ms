Drop database stu_grade_ms;
create database stu_grade_ms;
use stu_grade_ms;

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` char(10) NOT NULL,
  `name` char(10) default NULL,
  `password` char(10) NOT NULL,
  `class` char(20) default NULL,
  `major` char(20) default NULL,
  PRIMARY KEY  (`id`)
);

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('s001', 'SUNYI', '1', '1', 'CS');
INSERT INTO `student` VALUES ('s002', 'MARY', '2', '1', 'AI');
INSERT INTO `student` VALUES ('s003', 'JACK', '3', '1', 'CV');
INSERT INTO `student` VALUES ('s004', 'JHON', '4', '2', 'NLP');
INSERT INTO `student` VALUES ('s005', 'ROSE', '5', '2', 'IR');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` char(10) NOT NULL,
  `name` char(10) NOT NULL,
  `credit` double(4,2) default NULL,
  `time` char(20) NOT NULL,
  `address` char(10) NOT NULL
);

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('c001', 'java', '3.00', '周一：1-4节', 'A101教室');
INSERT INTO `course` VALUES ('c002', 'C++', '1.00', '周二：5-8节', 'A202教室');
INSERT INTO `course` VALUES ('c003', '网络实验', '2.00', '周三：1-4节', 'A303教室');
INSERT INTO `course` VALUES ('c004', 'javascript', '3.00', '周四：1-4节', 'A404教室');
INSERT INTO `course` VALUES ('c005', 'html', '4.00', '周五：5-8节', 'A505教室');
INSERT INTO `course` VALUES ('c006', 'css', '5.00', '周五：1-4节', 'A606教室');



-- ----------------------------
-- Table structure for `student_course`
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `sid` char(10) NOT NULL,
  `cid` char(10) NOT NULL,
  `grade` char(10) default NULL,
  PRIMARY KEY  (`sid`,`cid`)
);

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES ('s001', 'c001', '80');
INSERT INTO `student_course` VALUES ('s001', 'c002', '60');
INSERT INTO `student_course` VALUES ('s001', 'c003', '40');
INSERT INTO `student_course` VALUES ('s002', 'c001', '100');
INSERT INTO `student_course` VALUES ('s003', 'c001', '90');
INSERT INTO `student_course` VALUES ('s004', 'c001', '0');
INSERT INTO `student_course` VALUES ('s005', 'c001', '10');


-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` char(10) NOT NULL,
  `name` char(10) NOT NULL,
  `password` char(10) NOT NULL,
  `title` char(20) NOT NULL
);

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('t001', 'MR.WANG', '1','教授');
INSERT INTO `teacher` VALUES ('t002', 'MR.LEE', '2','副教授');
INSERT INTO `teacher` VALUES ('t003', 'MR.CHEN', '3','讲师');

-- ----------------------------
-- Table structure for `teacher_course`
-- ----------------------------
DROP TABLE IF EXISTS `teacher_course`;
CREATE TABLE `teacher_course` (
  `tid` char(10) NOT NULL,
  `cid` char(10) NOT NULL,
  PRIMARY KEY  (`tid`,`cid`)
);

-- ----------------------------
-- Records of teacher_course
-- ----------------------------
INSERT INTO `teacher_course` VALUES ('t001', 'c001');
INSERT INTO `teacher_course` VALUES ('t002', 'c002');
INSERT INTO `teacher_course` VALUES ('t003', 'c003');
INSERT INTO `teacher_course` VALUES ('t001', 'c002');
INSERT INTO `teacher_course` VALUES ('t001', 'c003');
INSERT INTO `teacher_course` VALUES ('t001', 'c004');
INSERT INTO `teacher_course` VALUES ('t001', 'c005');
INSERT INTO `teacher_course` VALUES ('t001', 'c006');

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` char(10) NOT NULL,
  `name` char(10) default NULL,
  `password` char(10) default NULL,
  PRIMARY KEY  (`id`)
);

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('m001', '张三','1');
INSERT INTO `manager` VALUES ('m002', '李四','2');



