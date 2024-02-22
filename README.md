This Quiz app is made using Retrofit for utilizing a custom API written in php,
accesing a local database in MySQL which responds in JSON format which is converted 
into POJO(Plain Old Java Objects) via GSON.
Retrofit automatically serialises the JSON response using a POJO(Plain Old Java Object) 
which must be defined  as Model class for the JSON Structure. 
To serialise JSON we use a converter to convert it into Gson.
The API is instantiated by Retrofit builder and it is accessed by an Interface named QuestionsAPI 
which has one operation to get All the questions available in the table, this all happens in the 
repository and sent to viewmodel which then passes it to view.
A ViewModel is used as bridge between repository and the views.

<video src="https://github.com/sanjuray/QuizAppMySQL/assets/94555333/f8b4ac25-69e1-4c09-b958-6f31ceefd332" width=450 height=500/>



