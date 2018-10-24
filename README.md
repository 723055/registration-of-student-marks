# course-system-application

/api/courses/{name}/{dateStart}/{dateFinish} createCourse - создание курса

/api/courses/{name} deleteCourse - удаление курса

/api/courses/{courseId}/add/{studentId} attachStudentToCourse - добавление студента на курс

/api/courses/{courseId}/delete/{studentId} deleteStudentToCourse - удаление студента из курса

/api/courses/course_list courseList - список курсов

/api/courses/get/{id} getCourseById - список студентов с оценками по датам у конкретного курса (по id курса)


/api/students/{name}/{phone}/{email} createStudent - добавление студента

/api/students/{id} deleteStudent - удаление студента из бд

/api/students/create createData - сделано для быстрого заполнения тестовыми данными в бд, запустить его в swagger перед началом тестирования

/api/students/student/{id}/{name}/{phone} changeStudentData - изменение данных студента

/api/students/list studentList - вывод списка всех студентов

