package com.example.kiddosafecard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EducationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.education);

        ImageButton babyWearingButton = findViewById(R.id.btn_baby_wearing);

        babyWearingButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=baby+wearing+article+for+new+mothers&client=safari&sca_esv=61e3094b30dbfd79&rls=en&sxsrf=ADLYWILhxAyyd6H1RyDuiVcVFiJf3f2dLQ%3A1720768748547&ei=7NiQZt6NIdWO4-EPutO7wAI&oq=Baby+Wearing%C2%A0&gs_lp=Egxnd3Mtd2l6LXNlcnAiDkJhYnkgV2VhcmluZ8KgKgIIADIEECMYJzIKEAAYgAQYFBiHAjIMEAAYgAQYQxiKBRgKMgUQABiABDIMEAAYgAQYQxiKBRgKMgUQABiABDIFEAAYgAQyBRAAGIAEMgoQABiABBhDGIoFMgUQABiABEjIF1CCBViCBXABeAGQAQCYAb0BoAG9AaoBAzAuMbgBAcgBAPgBAZgCAqACzgHCAgoQABiwAxjWBBhHwgINEAAYgAQYsAMYQxiKBcICDhAAGLADGOQCGNYE2AEBwgIZEC4YgAQYsAMY0QMYQxjHARjIAxiKBdgBApgDAIgGAZAGE7oGBggBEAEYCboGBggCEAEYCJIHAzEuMaAHoAc&sclient=gws-wiz-serp"));
            startActivity(intent);
        });

        TextView babyWearingTextView = findViewById(R.id.textView_wearing);

        babyWearingTextView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=baby+wearing+article+for+new+mothers&client=safari&sca_esv=61e3094b30dbfd79&rls=en&sxsrf=ADLYWILhxAyyd6H1RyDuiVcVFiJf3f2dLQ%3A1720768748547&ei=7NiQZt6NIdWO4-EPutO7wAI&oq=Baby+Wearing%C2%A0&gs_lp=Egxnd3Mtd2l6LXNlcnAiDkJhYnkgV2VhcmluZ8KgKgIIADIEECMYJzIKEAAYgAQYFBiHAjIMEAAYgAQYQxiKBRgKMgUQABiABDIMEAAYgAQYQxiKBRgKMgUQABiABDIFEAAYgAQyBRAAGIAEMgoQABiABBhDGIoFMgUQABiABEjIF1CCBViCBXABeAGQAQCYAb0BoAG9AaoBAzAuMbgBAcgBAPgBAZgCAqACzgHCAgoQABiwAxjWBBhHwgINEAAYgAQYsAMYQxiKBcICDhAAGLADGOQCGNYE2AEBwgIZEC4YgAQYsAMY0QMYQxjHARjIAxiKBdgBApgDAIgGAZAGE7oGBggBEAEYCboGBggCEAEYCJIHAzEuMaAHoAc&sclient=gws-wiz-serp"));
            startActivity(intent);
        });

        ImageButton babyFirstAidKitButton = findViewById(R.id.btn_baby_firstAid);

        babyFirstAidKitButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=babies+first+kit+article+for+new+mothers&client=safari&sca_esv=ad39667dfdf7fe91&rls=en&sxsrf=ADLYWIKm60BN7Jwdr89wwvsg-MsSr_naww%3A1720770200856&ei=mN6QZpaCNOyp4-EP-PSH2As&oq=Babies+first+kit%C2%A0&gs_lp=Egxnd3Mtd2l6LXNlcnAiEkJhYmllcyBmaXJzdCBraXTCoCoCCAAyBBAjGCcyBhAAGBYYHjIGEAAYFhgeMgYQABgWGB4yBhAAGBYYHjIGEAAYFhgeMggQABgWGB4YDzIGEAAYFhgeMgYQABgWGB4yBhAAGBYYHkjfC1CSAliSAnABeAGQAQCYAYsBoAGLAaoBAzAuMbgBAcgBAPgBAZgCAqAClwHCAgcQIxiwAxgnwgIKEAAYsAMY1gQYR5gDAIgGAZAGCZIHAzEuMaAH9Qc&sclient=gws-wiz-serp"));
            startActivity(intent);
        });

        TextView babyFirstAidKitTextView = findViewById(R.id.textView_firstAid);

        babyFirstAidKitTextView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=babies+first+kit+article+for+new+mothers&client=safari&sca_esv=ad39667dfdf7fe91&rls=en&sxsrf=ADLYWIKm60BN7Jwdr89wwvsg-MsSr_naww%3A1720770200856&ei=mN6QZpaCNOyp4-EP-PSH2As&oq=Babies+first+kit%C2%A0&gs_lp=Egxnd3Mtd2l6LXNlcnAiEkJhYmllcyBmaXJzdCBraXTCoCoCCAAyBBAjGCcyBhAAGBYYHjIGEAAYFhgeMgYQABgWGB4yBhAAGBYYHjIGEAAYFhgeMggQABgWGB4YDzIGEAAYFhgeMgYQABgWGB4yBhAAGBYYHkjfC1CSAliSAnABeAGQAQCYAYsBoAGLAaoBAzAuMbgBAcgBAPgBAZgCAqAClwHCAgcQIxiwAxgnwgIKEAAYsAMY1gQYR5gDAIgGAZAGCZIHAzEuMaAH9Qc&sclient=gws-wiz-serp"));
            startActivity(intent);
        });

        ImageButton learnDiaperingTeqButton = findViewById(R.id.btn_baby_diapering);

        learnDiaperingTeqButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.uk/search?q=learn+diapering+techniques+for+mothers&sca_esv=ad39667dfdf7fe91&ei=j_2QZpbFDbSTseMP7tew6AY&ved=0ahUKEwjWyIqInqGHAxW0SWwGHe4rDG0Q4dUDCA4&uact=5&oq=learn+diapering+techniques+for+mothers&gs_lp=Egxnd3Mtd2l6LXNlcnAiJmxlYXJuIGRpYXBlcmluZyB0ZWNobmlxdWVzIGZvciBtb3RoZXJzSIUcUOQYWOQYcAV4AZABAJgBpQKgAaUCqgEDMi0xuAEDyAEA-AEBmAIFoAIXwgIKEAAYsAMY1gQYR5gDAIgGAZAGCJIHATWgB1o&sclient=gws-wiz-serp"));
            startActivity(intent);
        });

        TextView learnDieaperingTeqTextView = findViewById(R.id.textView_baby_diapering);

        learnDieaperingTeqTextView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.uk/search?q=learn+diapering+techniques+for+mothers&sca_esv=ad39667dfdf7fe91&ei=j_2QZpbFDbSTseMP7tew6AY&ved=0ahUKEwjWyIqInqGHAxW0SWwGHe4rDG0Q4dUDCA4&uact=5&oq=learn+diapering+techniques+for+mothers&gs_lp=Egxnd3Mtd2l6LXNlcnAiJmxlYXJuIGRpYXBlcmluZyB0ZWNobmlxdWVzIGZvciBtb3RoZXJzSIUcUOQYWOQYcAV4AZABAJgBpQKgAaUCqgEDMi0xuAEDyAEA-AEBmAIFoAIXwgIKEAAYsAMY1gQYR5gDAIgGAZAGCJIHATWgB1o&sclient=gws-wiz-serp"));
            startActivity(intent);
        });

        ImageButton bondWithMotherButton = findViewById(R.id.btn_baby_bond);

        bondWithMotherButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.uk/search?q=Bond+with+your+baby+for+mothers&sca_esv=ad39667dfdf7fe91&ei=lf2QZs6cCcHiseMPteyZyAo&ved=0ahUKEwiOu_SKnqGHAxVBcWwGHTV2BqkQ4dUDCA4&uact=5&oq=Bond+with+your+baby+for+mothers&gs_lp=Egxnd3Mtd2l6LXNlcnAiH0JvbmQgd2l0aCB5b3VyIGJhYnkgZm9yIG1vdGhlcnMyCBAAGIAEGKIEMggQABiABBiiBEiDFlCaE1iaE3ABeAGQAQCYAcACoAHAAqoBAzMtMbgBA8gBAPgBAvgBAZgCAqAC1gLCAgoQABiwAxjWBBhHmAMAiAYBkAYIkgcFMS4zLTGgB98B&sclient=gws-wiz-serp"));
            startActivity(intent);
        });

        TextView bondWithMotherTextView = findViewById(R.id.textView_babybond);

        bondWithMotherTextView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.uk/search?q=Bond+with+your+baby+for+mothers&sca_esv=ad39667dfdf7fe91&ei=lf2QZs6cCcHiseMPteyZyAo&ved=0ahUKEwiOu_SKnqGHAxVBcWwGHTV2BqkQ4dUDCA4&uact=5&oq=Bond+with+your+baby+for+mothers&gs_lp=Egxnd3Mtd2l6LXNlcnAiH0JvbmQgd2l0aCB5b3VyIGJhYnkgZm9yIG1vdGhlcnMyCBAAGIAEGKIEMggQABiABBiiBEiDFlCaE1iaE3ABeAGQAQCYAcACoAHAAqoBAzMtMbgBA8gBAPgBAvgBAZgCAqAC1gLCAgoQABiwAxjWBBhHmAMAiAYBkAYIkgcFMS4zLTGgB98B&sclient=gws-wiz-serp"));
            startActivity(intent);
        });

    }
}

