var gulp = require('gulp');

var concat = require('gulp-concat');
var rename = require('gulp-rename');
var uglify = require('gulp-uglify');
var clean = require('gulp-clean');
var size = require('gulp-size');
var minifycss = require('gulp-minify-css');

/*
 *
 * 주 사용 커맨드 :
 *  1. gulp : 전체 빌드를 돌려서 distPath에 결과물 내놓음.
 *  2. gulp clean : distPath의 결과물 청소.
 *
 */

// 빌드가 끝난 후 최종 배포되는 파일이 저장되는 경로
var distPath = './src/main/webapp/resources/';

// 각 태스크별로 빌드 소스가 되는 파일들의 경로(src)와 빌드 후 대상 경로(dest, filename)
var filePath = {
	commonCss: {
		src: [
			'src/main/webapp/resources/css/common.css',
		],
		dest: distPath,
		filename: 'css/common.min.css'
	},

	friendsJs: {
		src: [
			'src/main/webapp/resources/js/friends.js'
		],
		dest: distPath,
		filename: 'js/friends.min.js'
	},

	commonJs: {
		src: [
			'src/main/webapp/resources/js/common.js'
		],
		dest: distPath,
		filename: 'js/common.min.js'
	}
};

/* CSS concat + minify */
gulp.task('css-compress', ['common-css']);

gulp.task('common-css', function () {
	return cssMinify(filePath.commonCss);
});

function cssMinify(obj) {
	return gulp.src(obj.src)
		.pipe(minifycss())
		.pipe(concat(obj.filename))
		.pipe(size({title: obj.filename}))
		.pipe(gulp.dest(obj.dest));
}


/* JS concat + minify */
gulp.task('js-compress', ['friends-js','common-js']);


gulp.task('friends-js', function () {
	return jsMinify(filePath.friendsJs);
});

gulp.task('common-js', function () {
	return jsMinify(filePath.commonJs);
});

function jsMinify(obj) {
	return gulp.src(obj.src)
		.pipe(uglify())
		.pipe(concat(obj.filename, {newLine: ';'}))
		.pipe(size({title: obj.filename}))
		.pipe(gulp.dest(obj.dest));
}

gulp.task('default', ['css-compress', 'js-compress'] );