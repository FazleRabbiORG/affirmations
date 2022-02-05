package com.fazlerabbi.affirmation.data

import com.fazlerabbi.affirmation.R
import com.fazlerabbi.affirmation.model.Affirmation

class Datasource {
    fun loadAffirmation(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1,R.drawable.account_circle_24),
            Affirmation(R.string.affirmation2,R.drawable.account_circle_24),
            Affirmation(R.string.affirmation3,R.drawable.account_circle_24),
            Affirmation(R.string.affirmation4,R.drawable.account_circle_24),
            Affirmation(R.string.affirmation5,R.drawable.account_circle_24),
            Affirmation(R.string.affirmation6,R.drawable.account_circle_24),
            Affirmation(R.string.affirmation7,R.drawable.account_circle_24),
            Affirmation(R.string.affirmation8,R.drawable.account_circle_24),
            Affirmation(R.string.affirmation9,R.drawable.account_circle_24),
            Affirmation(R.string.affirmation10,R.drawable.account_circle_24)
        )
    }
}