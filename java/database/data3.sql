SELECT f.flashcard_id , f.question, f.answer FROM flashcard f
JOIN flashcard_user fu ON f.flashcard_id = fu.flashcard_id
JOIN users u ON  u.user_id = fu.user_id
 WHERE f.flashcard_id = 11  AND u.user_id = 1
 
SELECT f.flashcard_id, f.question, f.answer FROM flashcard f  
                JOIN flashcard_keyword ck ON f.flashcard_id = ck.flashcard_id 
                JOIN flashcard_user fu ON f.flashcard_id = fu.flashcard_id 
                WHERE ck.keyword  ILIKE  'Addition' AND fu.user_id = 1;
                
                
                
                UPDATE flashcard AS f 
                SET f.question = 'jhjhj', f.answer = 'jhjhjiuiii'
                JOIN flashcard_user fu ON f.flashcard_id = fu.flashcard_id 
                JOIN users u ON u.user_id = fu.user_id
                WHERE flashcard_id =11 AND fu.user_id = 1
                ;
                
                UPDATE flashcard AS f 
                SET question = 'ABC', answer = 'XYZ'
                FROM flashcard_user AS fu, users AS u
                where f.flashcard_id = fu.flashcard_id 
                AND u.user_id = fu.user_id
                AND f.flashcard_id =9 AND fu.user_id = 1;
                
               /* WHERE LOWER(name)=LOWER('Administrator')*/